package com.societe.generale.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.societe.generale.constants.EmployeePortalConstants;
import com.societe.generale.exception.ApplicationException;
import com.societe.generale.logger.AppLoggerAdapter;
import com.societe.generale.logger.GenericLoggerAdapter;
import com.societe.generale.model.Employee;
import com.societe.generale.repository.EmployeeRepository;

@Transactional
@Repository
public class EmployeePortalDaoImpl implements EmployeePortalDao {

	/**
	 * GenericLoggerAdapter logger.
	 */
	private GenericLoggerAdapter logger = new AppLoggerAdapter(EmployeePortalDaoImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveEmployee(Employee employee) throws ApplicationException {
		try {
			employeeRepository.save(employee);
		} catch (Exception e) {
			logger.error("Error in Saving Employee Data :: " + e.getMessage());
			throw new ApplicationException("Error in Saving employee data " + e.getMessage());
		}
	}

	@Override
	public List<Employee> getEmployees() throws ApplicationException {
		List<Employee> employees = new ArrayList<>();
		try {
			StringBuilder selectRoles = new StringBuilder();
			selectRoles.append(EmployeePortalConstants.FROM).append(EmployeePortalConstants.EMPLOYEE)
					.append(EmployeePortalConstants.ORDER_BY).append(EmployeePortalConstants.FIRSTNAME);
			employees = entityManager.createQuery(selectRoles.toString()).getResultList();
		} catch (Exception e) {
			logger.error("Error in getting Employee Data :: " + e.getMessage());
			throw new ApplicationException("Error in getting employee data " + e.getMessage());
		}
		return employees;
	}

}
