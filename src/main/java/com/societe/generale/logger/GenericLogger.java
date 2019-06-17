package com.societe.generale.logger;

public interface GenericLogger {
	public void info(String message);
	public void debug(String message);
	public void error(String message);
	public void error(String message, Throwable error);
	public Class<?> getLoggerName();
	public void setLoggerName(Class<?> logger);
}
