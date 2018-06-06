package com.zyj.sessionClient;

import org.apache.log4j.Logger;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.zyj.sessionClient.entry.SessionClient;
import com.zyj.sessionClient.util.PropertiesUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * main
 *
 */
public class App {
	private static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		PropertiesUtil propertiesUtil = new PropertiesUtil(
				System.getProperty("user.dir") + "/src/sessionClient.properties");
		int concurrency = Integer.parseInt(propertiesUtil.get("Concurrency"));
		int time = Integer.parseInt(propertiesUtil.get("time"));
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(concurrency);
		int count = 10;
		for (int i = 0; i < 10; i++) {
			final int id = i;
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {

					SessionClient demo1 = new SessionClient(id, time);
				}

			});
		}
		fixedThreadPool.shutdown();
	}
}
