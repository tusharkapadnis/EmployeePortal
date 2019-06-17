package com.societe.generale.repository;

import org.springframework.stereotype.Repository;

import com.societe.generale.model.Employee;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Integer> {
	

	
}