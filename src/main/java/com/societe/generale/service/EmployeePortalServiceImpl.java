package com.societe.generale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.generale.dao.EmployeePortalDao;
import com.societe.generale.dto.EmployeeDetails;
import com.societe.generale.exception.ApplicationException;
import com.societe.generale.logger.AppLoggerAdapter;
import com.societe.generale.logger.GenericLoggerAdapter;
import com.societe.generale.model.Employee;
import com.societe.generale.util.DAOHelper;

@Service
public class EmployeePortalServiceImpl implements EmployeePortalService {

	@Autowired
	private EmployeePortalDao employeeDao;

	@Autowired
	private DAOHelper daoHelper;

	private GenericLoggerAdapter logger = new AppLoggerAdapter(EmployeePortalServiceImpl.class);

	@Override
	public EmployeeDetails saveEmployeeDeatils(EmployeeDetails employeeDetails) throws ApplicationException {
		try {
			Employee employee = daoHelper.getEmployee(employeeDetails);
			employeeDao.saveEmployee(employee);
		} catch (ApplicationException e) {
			logger.error("Error in Saving Employee Data :: " + e.getMessage());
			throw new ApplicationException("Error in Saving data" + e.getMessage());
		}
		return employeeDetails;
	}

	@Override
	public List<EmployeeDetails> getEmployeeDetails() throws ApplicationException {
		List<EmployeeDetails> employeeDetails = null;
		try {
			List<Employee> employeeList = employeeDao.getEmployees();
			employeeDetails = daoHelper.getEmployeeDetails(employeeList);
		} catch (ApplicationException e) {
			logger.error("Error in Saving Employee Data :: " + e.getMessage());
			throw new ApplicationException("Error in Saving data" + e.getMessage());
		}
		return employeeDetails;
	}
}
