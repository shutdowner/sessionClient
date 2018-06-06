package com.zyj.sessionClient.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.junit.platform.commons.util.StringUtils;

/**  
* @ClassName: ProportiesUtil  
* @Description: 
* @author zhuyongjie
* @date 2018年6月7日  
*    
*/
	public class PropertiesUtil {  
		  
	    private static Logger logger = Logger.getLogger(PropertiesUtil.class);  
	  
	    private Properties props;

	    public PropertiesUtil(String fileName) {
	        readProperties(fileName);
	    }

	    /**
	     * 加载配置文件
	     * 
	     * @param fileName
	     */
	    private void readProperties(String fileName) {
	        try {
	            props = new Properties();
	            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
	            props.load(bufferedReader);
	        } catch (Exception e) {
	        	logger.error(e.getMessage());;
	        }
	    }

	    /**
	     * 根据key读取对应的value
	     * 
	     * @param key
	     * @return
	     */
	    public String get(String key) {
	        return props.getProperty(key);
	    }
	} 
