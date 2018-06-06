package com.zyj.sessionClient.entry;

import java.io.StringWriter;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.zyj.sessionClient.api.SessionFeign;
import com.zyj.sessionClient.util.JaxbWriteXml;
import com.zyj.sessionClient.util.PropertiesUtil;
import com.zyj.sessionClient.util.Slf4jLogger;

import feign.Feign;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

/**
 * @ClassName: SessionClient
 * @Description:
 * @author zhuyongjie
 * @date 2018年6月6日
 * 
 */
public class SessionClient {
	int id;
	int time = 5;
	private static Logger logger = Logger.getLogger(SessionClient.class);
	PropertiesUtil propertiesUtil = new PropertiesUtil(
			System.getProperty("user.dir") + "/src/sessionClient.properties");
	String url = propertiesUtil.get("url");

	public SessionClient(int id, int time) {
		this.id = id;
		this.time = time;
		try {
			start();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			logger.error(e.getStackTrace());
		}
	}

	private void start() throws JAXBException {
		post(ActionType.START);
		logger.info("id:" + id + "session已开始");
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ExecutorService executorService = Executors.newCachedThreadPool();
				try {
					executorService.submit(() -> {
						try {
							stop();
						} catch (JAXBException e) {
							logger.error(e.getMessage());
						}
					});

				} catch (Exception e) {
					logger.error(e.getMessage());
				} finally {
					executorService.shutdown();
					timer.cancel();
				}

			}
		}, time * 1000);
		
	}

	private void stop() throws JAXBException {
		post(ActionType.STOP);
		logger.info("id:" + id + "session已停止");
	}

	private void post(ActionType type) throws JAXBException {
		Marshaller marshaller = JaxbWriteXml.getMarshaller(DeliverySessionCreationType.class);
		DeliverySessionCreationType demo = new DeliverySessionCreationType();
		demo.setDeliverySessionId(id);
		demo.setAction(type);
		final StringWriter stringWriter = new StringWriter();
		marshaller.marshal(demo, stringWriter);
		try {
			Feign.builder().logger(new Slf4jLogger(SessionClient.class)).encoder(new JAXBEncoder(null))
					.decoder(new JAXBDecoder(null)).target(SessionFeign.class, url)
					.sessionTest(stringWriter.toString(), id);
			logger.info("url:" + url + "body" + stringWriter.toString() + " 连接成功 ");
		} catch (Exception e) {
			logger.error("url:" + url + "body" + stringWriter.toString() + " 连接失败 ");
		}
	}
}
