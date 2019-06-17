package com.societe.generale.service;

import java.util.List;

import com.societe.generale.dto.EmployeeDetails;
import com.societe.generale.exception.ApplicationException;

public interface EmployeePortalService {

	EmployeeDetails saveEmployeeDeatils(EmployeeDetails employeeDeails) throws ApplicationException;

	List<EmployeeDetails> getEmployeeDetails() throws ApplicationException;

}
