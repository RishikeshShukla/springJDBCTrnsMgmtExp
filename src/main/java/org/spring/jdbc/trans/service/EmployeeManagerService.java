package org.spring.jdbc.trans.service;

import java.util.List;

import org.spring.jdbc.trans.model.Employee;

public interface EmployeeManagerService {

	public void createEmployee(Employee employee);
	
	Employee getEmployee(int id);
	
	List<Employee> getAllEmployees();
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(int id);
}
