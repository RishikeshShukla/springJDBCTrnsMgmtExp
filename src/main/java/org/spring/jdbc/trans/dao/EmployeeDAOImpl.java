package org.spring.jdbc.trans.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.spring.jdbc.trans.model.Employee;
import org.spring.jdbc.trans.util.EmployeeRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String INSERT_EMPLOYEE_QUERY = "insert into employee (id, name) values (?,?)";
	private static final String INSERT_ADDRESS_QUERY = "insert into address (id, area,country) values (?,?,?)";

	private static final String GET_EMPLOYEE_QUERY = "select * from employee where id = ?";

	private static final String UPDATE_EMPLOYEE_QUERY = "update employee set name = ? where id = ? ";
	
	private static final String DELETE_EMPLOYEE_QUERY = "delete from employee where id = ?";
	
	private static final String SELECT_ALL_EMMPLOYEE_QUERY = "select id, name from Employee";
	
	private JdbcTemplate springJdbcTemplate;

	public void setSpringJdbcTemplate(JdbcTemplate springJdbcTemplate) {
		this.springJdbcTemplate = springJdbcTemplate;
	}

	public void createEmployee(Employee employee) {
		springJdbcTemplate.update(INSERT_EMPLOYEE_QUERY, new Object[] { employee.getId(), employee.getName() });

		System.out.println("Inserted into Employee Table Successfully");

		springJdbcTemplate.update(INSERT_ADDRESS_QUERY,
				new Object[] { employee.getId(), employee.getAddress().getArea(), employee.getAddress().getCountry() });

		System.out.println("Inserted into Address Table Successfully");
	}

	@Override
	public Employee getEmployee(int id) {

	/*	Employee employee = (Employee) springJdbcTemplate.queryForObject(GET_EMPLOYEE_QUERY, new Object[] { id },
				new BeanPropertyRowMapper<Employee>(Employee.class));*/

		
		Employee employee = (Employee) springJdbcTemplate.queryForObject(GET_EMPLOYEE_QUERY, new Object[] { id },
				new EmployeeRowMapper());

		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {

		int updateResult = springJdbcTemplate.update(UPDATE_EMPLOYEE_QUERY,
				new Object[] { employee.getName(), employee.getId() });

		if (updateResult != 0) {
			System.out.println("Employee updated with id=" + employee.getId());
		} else {
			System.out.println("No Employee found with id=" + employee.getId());
		}

	}

	@Override
	public void deleteEmployee(int id) {

		int deleteResult = springJdbcTemplate.update(DELETE_EMPLOYEE_QUERY, new Object[] { id });

		if (deleteResult != 0) {
			System.out.println("Employee deleted with id=" + id);
		} else {
			System.out.println("No Employee found with id=" + id);
		}
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		
		List<Employee> empList = new ArrayList<Employee>();
		
		/*List<Employee> queryResult = springJdbcTemplate.query(SELECT_ALL_EMMPLOYEE_QUERY,
				new BeanPropertyRowMapper<Employee>(Employee.class));
		*/
		
		List<Map<String, Object>> queryResult = springJdbcTemplate.queryForList(SELECT_ALL_EMMPLOYEE_QUERY);
		
		for(Map<String, Object> empMap : queryResult){
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(String.valueOf(empMap.get("id"))));
			emp.setName(String.valueOf(empMap.get("name")));			
			empList.add(emp);
		}
		
		return empList;
	}
}
