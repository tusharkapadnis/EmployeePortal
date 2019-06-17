package com.societe.generale.logger;

import org.slf4j.LoggerFactory;


public class Slf4jLogManager implements GenericLogger {
	
	private Class<?> loggerName;
	public Class<?> getLoggerName() {
		return loggerName;
	}
	public void setLoggerName(Class<?> loggerName) {
		this.loggerName = loggerName;
	}
	@Override
	public void info(String message) {
		LoggerFactory.getLogger(loggerName).info(message);
	}

	@Override
	public void debug(String message) {
		LoggerFactory.getLogger(loggerName).debug(message);
		
	}

	@Override
	public void error(String message) {
		LoggerFactory.getLogger(loggerName).error(message);
		
	}

	@Override
	public void error(String message, Throwable exception) {
		LoggerFactory.getLogger(loggerName).error(message,exception);
		
	}

}
