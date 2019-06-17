package com.societe.generale.server;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@Import(EmployeePortalServerConfiguration.class)
public class EmployeeServiceServer extends SpringBootServletInitializer {

	@Autowired
	private EmployeePortalServiceConfigProperties employeeConfigProperties;

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EmployeeServiceServer.class);
	}

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			System.setProperty("server.port", args[0]);
		}
		SpringApplication.run(EmployeeServiceServer.class, args);
	}

	@Primary
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(employeeConfigProperties.getDriverClass());
		dataSource.setUrl(employeeConfigProperties.getJdbcurl());
		dataSource.setUsername(employeeConfigProperties.getUserName());
		dataSource.setPassword(employeeConfigProperties.getPassword());
		return dataSource;
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(employeeConfigProperties.getPackagesToScan());
		//entityManagerFactoryBean.setPersistenceUnitName(employeeConfigProperties.getPersistenceUnitName());
		entityManagerFactoryBean.setJpaProperties(hibProperties());
		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", employeeConfigProperties.getDialectValue());
		properties.put("hibernate.show_sql", employeeConfigProperties.getShowSQL());
		properties.put("hibernate.hbm2ddl.auto", employeeConfigProperties.getDdlauto());
		return properties;
	}

	@Primary
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
