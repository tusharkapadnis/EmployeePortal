package com.societe.generale.logger;

public class LogManagerFactory {
	
	public GenericLogger getLogManager(String loggerType) {
		if("slf4j".equals(loggerType))
			return new Slf4jLogManager();
		return null;
	}
}
