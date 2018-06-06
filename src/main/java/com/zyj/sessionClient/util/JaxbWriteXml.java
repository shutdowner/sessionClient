package com.zyj.sessionClient.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.jupiter.api.Test;

import com.zyj.sessionClient.entry.ActionType;
import com.zyj.sessionClient.entry.DeliverySessionCreationType;

/**  
* @ClassName: JaxbWriteXml  
* @Description: 
* @author zhuyongjie
* @date 2018年6月6日  
*    
*/
public class JaxbWriteXml {
	 public static <T> Marshaller getMarshaller(Class<T> c) throws JAXBException{  
         
	        JAXBContext context = JAXBContext.newInstance(c);  
	        Marshaller marshaller = context.createMarshaller();   
	        //编码格式   
	        marshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");  
	        //是否格式化生成的xml串      
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	        //是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）  
	        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);  
	          
	        return marshaller;  
	    }
	 	@Test  
	    public void test_xml() throws JAXBException{  
	        Marshaller marshaller = getMarshaller(DeliverySessionCreationType.class);  
	        DeliverySessionCreationType demo = new DeliverySessionCreationType(); 
	        demo.setDeliverySessionId(5);
	        demo.setAction(ActionType.START);
	        final StringWriter stringWriter = new StringWriter();  
	        marshaller.marshal(demo, stringWriter);
	        String chartXml = stringWriter.toString();
	        System.out.println(chartXml);
	    } 
}
