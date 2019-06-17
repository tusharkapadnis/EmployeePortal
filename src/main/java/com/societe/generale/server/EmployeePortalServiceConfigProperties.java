package com.societe.generale.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("config")
public class EmployeePortalServiceConfigProperties {
	private String driverClass;
	private String jdbcurl;
	private int connectionPoolInitialSize;
	private int maxActiveConnections;
	private boolean defaultAutoCommit;
	private String userName;
	private String packagesToScan;
	private String persistenceUnitName;
	private String dialectValue;
	private String showSQL;
	private String ddlauto;
	private String connectionPoolMinSize;
	private String connectionPoolMaxSize;
	private String connectionTimeOut;
	private String connectionMaxStatements;
	private String conenctionIdleTestPeriod;
	private int acquireIncrement;
    
    private int maxStatements;
    
    public int getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(int acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}

	public int getMaxStatements() {
		return maxStatements;
	}

	public void setMaxStatements(int maxStatements) {
		this.maxStatements = maxStatements;
	}
	
	public String getConnectionPoolMinSize() {
		return connectionPoolMinSize;
	}
	public void setConnectionPoolMinSize(String connectionPoolMinSize) {
		this.connectionPoolMinSize = connectionPoolMinSize;
	}
	public String getConnectionPoolMaxSize() {
		return connectionPoolMaxSize;
	}
	public void setConnectionPoolMaxSize(String connectionPoolMaxSize) {
		this.connectionPoolMaxSize = connectionPoolMaxSize;
	}
	public String getConnectionTimeOut() {
		return connectionTimeOut;
	}
	public void setConnectionTimeOut(String connectionTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
	}
	public String getConnectionMaxStatements() {
		return connectionMaxStatements;
	}
	public void setConnectionMaxStatements(String connectionMaxStatements) {
		this.connectionMaxStatements = connectionMaxStatements;
	}
	public String getConenctionIdleTestPeriod() {
		return conenctionIdleTestPeriod;
	}
	public void setConenctionIdleTestPeriod(String conenctionIdleTestPeriod) {
		this.conenctionIdleTestPeriod = conenctionIdleTestPeriod;
	}
	
	public String getDdlauto() {
		return ddlauto;
	}
	public void setDdlauto(String ddlauto) {
		this.ddlauto = ddlauto;
	}
	public String getPackagesToScan() {
		return packagesToScan;
	}
	public void setPackagesToScan(String packagesToScan) {
		this.packagesToScan = packagesToScan;
	}
	public String getPersistenceUnitName() {
		return persistenceUnitName;
	}
	public void setPersistenceUnitName(String persistenceUnitName) {
		this.persistenceUnitName = persistenceUnitName;
	}
	public String getDialectValue() {
		return dialectValue;
	}
	public void setDialectValue(String dialectValue) {
		this.dialectValue = dialectValue;
	}
	public String getShowSQL() {
		return showSQL;
	}
	public void setShowSQL(String showSQL) {
		this.showSQL = showSQL;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getJdbcurl() {
		return jdbcurl;
	}
	public void setJdbcurl(String jdbcurl) {
		this.jdbcurl = jdbcurl;
	}
	public int getConnectionPoolInitialSize() {
		return connectionPoolInitialSize;
	}
	public void setConnectionPoolInitialSize(int connectionPoolInitialSize) {
		this.connectionPoolInitialSize = connectionPoolInitialSize;
	}
	public int getMaxActiveConnections() {
		return maxActiveConnections;
	}
	public void setMaxActiveConnections(int maxActiveConnections) {
		this.maxActiveConnections = maxActiveConnections;
	}
	public boolean isDefaultAutoCommit() {
		return defaultAutoCommit;
	}
	public void setDefaultAutoCommit(boolean defaultAutoCommit) {
		this.defaultAutoCommit = defaultAutoCommit;
	}
	
}
