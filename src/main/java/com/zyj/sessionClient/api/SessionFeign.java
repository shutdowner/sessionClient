package com.zyj.sessionClient.api;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/** *
 * 
* @ClassName: SessionFeign  
* @Description: 
* @author zhuyongjie
* @date 2018年6月6日  
*
 */
public interface  SessionFeign {
	@RequestLine("POST /nbi/deliverysession?id={DeliverySessionId}")
	@Headers("Content-Type: application/xml")
	@Body("{body}")
	void sessionTest(@Param("body") String body,@Param("DeliverySessionId") int id);
}
