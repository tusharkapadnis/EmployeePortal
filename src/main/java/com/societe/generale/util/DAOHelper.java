package com.societe.generale.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.societe.generale.dto.EmployeeDetails;
import com.societe.generale.model.Employee;

@Component
public class DAOHelper {
	public Employee getEmployee(EmployeeDetails employeeDetails) {
		Employee employee = new Employee();
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setDepartment(employeeDetails.getDepartment());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setGender(employeeDetails.getGender());
		return employee;
	}

	public List<EmployeeDetails> getEmployeeDetails(List<Employee> employeeList) {
		List<EmployeeDetails> employeeDetails = new ArrayList<>();
		for (Employee emp : employeeList) {
			EmployeeDetails empDetails = new EmployeeDetails();
			empDetails.setDateOfBirth(emp.getDateOfBirth());
			empDetails.setDepartment(emp.getDepartment());
			empDetails.setFirstName(emp.getFirstName());
			empDetails.setGender(emp.getGender());
			empDetails.setLastName(emp.getLastName());
			employeeDetails.add(empDetails);
		}
		return employeeDetails;
	}
}
