package com.societe.generale.dao;

import java.util.List;

import com.societe.generale.exception.ApplicationException;
import com.societe.generale.model.Employee;

public interface EmployeePortalDao {

	void saveEmployee(Employee employee) throws ApplicationException;

	List<Employee> getEmployees() throws ApplicationException;

}
