package com.zyj.sessionClient.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import feign.Request;
import feign.Response;
/**  
* @ClassName: Slf4jLogger  
* @Description: 
* @author zhuyongjie
* @date 2018年6月7日  
*    
*/
public class Slf4jLogger extends feign.Logger {

  private final Logger logger;

  public Slf4jLogger() {
    this(feign.Logger.class);
  }

  public Slf4jLogger(Class<?> clazz) {
    this(LoggerFactory.getLogger(clazz));
  }

  public Slf4jLogger(String name) {
    this(LoggerFactory.getLogger(name));
  }

  Slf4jLogger(Logger logger) {
    this.logger = logger;
  }

  @Override
  protected void logRequest(String configKey, Level logLevel, Request request) {
    if (logger.isDebugEnabled()) {
      super.logRequest(configKey, logLevel, request);
    }
  }

  @Override
  protected Response logAndRebufferResponse(String configKey,
                                            Level logLevel,
                                            Response response,
                                            long elapsedTime)
      throws IOException {
    if (logger.isDebugEnabled()) {
      return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
    }
    return response;
  }

  @Override
  protected void log(String configKey, String format, Object... args) {
    // Not using SLF4J's support for parameterized messages (even though it would be more efficient)
    // because it would
    // require the incoming message formats to be SLF4J-specific.
    if (logger.isDebugEnabled()) {
      logger.debug(String.format(methodTag(configKey) + format, args));
    }
  }
}
