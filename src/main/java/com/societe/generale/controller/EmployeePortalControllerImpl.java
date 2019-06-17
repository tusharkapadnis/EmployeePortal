package com.societe.generale.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.societe.generale.dto.EmployeeDetails;
import com.societe.generale.exception.ApplicationException;
import com.societe.generale.logger.AppLoggerAdapter;
import com.societe.generale.logger.GenericLoggerAdapter;
import com.societe.generale.service.EmployeePortalService;

@RestController
@CrossOrigin(maxAge = 3600)
public class EmployeePortalControllerImpl implements EmployeePortalController {

	@Autowired
	private EmployeePortalService employeeService;

	private GenericLoggerAdapter logger = new AppLoggerAdapter(EmployeePortalControllerImpl.class);
	
	private static final String AUTHENTICATION_FAILURE = "{\"error\":\"Authentication Failed\"}";
	
	@Override
	public ResponseEntity<Object> saveEmployeeDeatils(@RequestBody EmployeeDetails employeeDeails,@RequestHeader("authorization") String authString) throws ApplicationException {
		if (!isUserAuthenticated(authString)) {
			return new ResponseEntity<>(AUTHENTICATION_FAILURE, HttpStatus.FORBIDDEN);
		}
		try {
			return ResponseEntity.ok(employeeService.saveEmployeeDeatils(employeeDeails));
		} catch (ApplicationException e) {
			logger.error("Failed to save data");
			throw new ApplicationException("Error in Saving data" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<Object> getEmployeeDetails(@RequestHeader("authorization") String authString) throws ApplicationException {
		if (!isUserAuthenticated(authString)) {
			return new ResponseEntity<>(AUTHENTICATION_FAILURE, HttpStatus.FORBIDDEN);
		}
		try {
			return ResponseEntity.ok(employeeService.getEmployeeDetails());
		} catch (ApplicationException e) {
			logger.error("Failed to get data");
			throw new ApplicationException("Error in getting data" + e.getMessage());
		}
	}
	private boolean isUserAuthenticated(String authString) {
		String[] authParts = authString.split("\\s+");
		if (authParts.length == 2) {
			String authInfo = authParts[1];
			// Decode the data back to original string
			//logger.info("authInfo " + authInfo);
			byte[] decodedBytes = null;
			try {
				decodedBytes = Base64.decodeBase64(authInfo.getBytes());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			String origString = new String(decodedBytes);
			//logger.info("decodedBytes " + origString);
			return "user:serN+34#567".equals(origString);
		}
		return false;
	}
}
