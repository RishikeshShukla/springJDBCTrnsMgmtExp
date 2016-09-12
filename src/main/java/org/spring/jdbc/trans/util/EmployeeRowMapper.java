package org.spring.jdbc.trans.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.spring.jdbc.trans.model.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setName(rs.getString("NAME"));
		employee.setId(rs.getInt("ID"));
		return employee;
	}



}
