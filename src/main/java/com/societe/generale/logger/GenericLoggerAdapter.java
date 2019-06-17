package com.societe.generale.logger;

public abstract class GenericLoggerAdapter {
	
	private GenericLogger genericLogger;
	public void setGenericLogger(GenericLogger genericLogger) {
		this.genericLogger = genericLogger;
	}
	public GenericLogger getGenericLogger() {
		return genericLogger;
	}
	public abstract void info(String message);
	public abstract void debug(String message);
	public abstract void error(String message);
	public abstract void error(String message, Throwable error);
	public abstract Class<?> getLoggerName();
	public abstract void setLoggerName(Class<?> logger);

}
