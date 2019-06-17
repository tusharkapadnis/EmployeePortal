package com.societe.generale.logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <pre>
 * <b>Description : </b>
 * AppLoggerAdapter.
 * 
 * </pre>
 */
public class AppLoggerAdapter extends GenericLoggerAdapter {
    /**
     * Class<?> loggerName.
     */
    private Class<?> loggerName;

    /**
     * <pre>
     * <b>Description : </b>
     * AppLoggerAdapter.
     * 
     * @param loggerName , may be null
     * </pre>
     */
    public AppLoggerAdapter(Class<?> loggerName) {
        this.loggerName = loggerName;
        LogManagerFactory logManagerFactory = new LogManagerFactory();
        Properties props = new Properties();
        InputStream inputstream = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            inputstream = classLoader.getResourceAsStream("application.properties");
            props.load(inputstream);
        }
        catch (IOException ioe) {
            throw new RuntimeException("Unable to load application.properties");
        }
        GenericLogger genericLogger = logManagerFactory.getLogManager(props.getProperty("loggertype"));
        setGenericLogger(genericLogger);
    }

    /**
     * <pre>
     * <b>Description : </b>
     * info.
     * 
     * @param message , may be null
     * </pre>
     */
    @Override
    public void info(String message) {
        getGenericLogger().setLoggerName(getLoggerName());
        getGenericLogger().info(message);
    }

    /**
     * <pre>
     * <b>Description : </b>
     * debug.
     * 
     * @param message , may be null
     * </pre>
     */
    @Override
    public void debug(String message) {
        getGenericLogger().setLoggerName(getLoggerName());
        getGenericLogger().debug(message);

    }

    /**
     * <pre>
     * <b>Description : </b>
     * error.
     * 
     * @param message , may be null
     * </pre>
     */
    @Override
    public void error(String message) {
        getGenericLogger().setLoggerName(getLoggerName());
        getGenericLogger().error(message);

    }

    /**
     * <pre>
     * <b>Description : </b>
     * error.
     * 
     * @param error , may be null
     * @param message , may be null
     * </pre>
     */
    @Override
    public void error(String message, Throwable error) {
        getGenericLogger().setLoggerName(getLoggerName());
        getGenericLogger().error(message, error);

    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'Class' attribute value.
     * 
     * @return Class<?> , null if not found
     * </pre>
     */
    @Override
    public Class<?> getLoggerName() {
        return loggerName;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'loggerNameParam' attribute value.
     * 
     * @param loggerNameParam , may be null
     * </pre>
     */
    @Override
    public void setLoggerName(final Class<?> loggerNameParam) {
        this.loggerName = loggerNameParam;

    }

}
