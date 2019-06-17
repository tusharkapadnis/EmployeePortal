package com.societe.generale.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.societe.generale.dto.EmployeeDetails;
import com.societe.generale.exception.ApplicationException;

public interface EmployeePortalController {

	@RequestMapping(value = "/register/EmployeeDetails", method = RequestMethod.POST)
	ResponseEntity<Object> saveEmployeeDeatils(@RequestBody EmployeeDetails employeeDeails,@RequestHeader("authorization") String authString) throws ApplicationException;

	@RequestMapping(value = "/get/EmployeeDetails", method = RequestMethod.GET)
	ResponseEntity<Object> getEmployeeDetails(@RequestHeader("authorization") String authString) throws ApplicationException;
}
