package com.societe.generale.server;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.societe.generale.dao.EmployeePortalDao;
import com.societe.generale.dao.EmployeePortalDaoImpl;
import com.societe.generale.service.EmployeePortalService;
import com.societe.generale.service.EmployeePortalServiceImpl;

@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableCaching
@EnableJpaRepositories("com.societe.generale.repository")
@ComponentScan(basePackages = { "com.societe.*" })
public class EmployeePortalServerConfiguration {
	
	/*@Bean
	public EmployeePortalService EmployeePortalService() {
		EmployeePortalService employeePortalService = new EmployeePortalServiceImpl();
		return employeePortalService;
	}

	@Bean
	public EmployeePortalDao employeePortalDao() {
		EmployeePortalDao employeePortalDao = new EmployeePortalDaoImpl();
		return employeePortalDao;
	}*/

}
