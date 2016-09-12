package org.spring.jdbc.trans.service;

import java.util.List;

import org.spring.jdbc.trans.dao.EmployeeDAO;
import org.spring.jdbc.trans.model.Employee;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeManagerServiceImpl implements EmployeeManagerService {

	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO empDAO) {
		this.employeeDAO = empDAO;
	}

	@Transactional
	@Override
	public void createEmployee(Employee employee) {
		employeeDAO.createEmployee(employee);
	}

	@Transactional
	@Override
	public Employee getEmployee(int id) {
		return employeeDAO.getEmployee(id);
	}

	@Transactional
	@Override
	public void updateEmployee(Employee employee) {

		employeeDAO.updateEmployee(employee);
	}

	@Transactional
	@Override
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
	}

	@Transactional
	@Override
	public List<Employee> getAllEmployees() {
 
		return employeeDAO.getAllEmployees();
	}

}
