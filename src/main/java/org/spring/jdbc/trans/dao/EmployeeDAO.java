package org.spring.jdbc.trans.dao;

import java.util.List;

import org.spring.jdbc.trans.model.Employee;

public interface EmployeeDAO {

	void createEmployee(Employee employee);

	Employee getEmployee(int id);

	void updateEmployee(Employee employee);

	void deleteEmployee(int id);

	List<Employee> getAllEmployees();

}
