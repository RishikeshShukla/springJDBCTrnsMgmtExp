package org.spring.jdbc.trans.test;

import org.spring.jdbc.trans.model.Address;
import org.spring.jdbc.trans.model.Employee;
import org.spring.jdbc.trans.service.EmployeeManagerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTnxMngrTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeManagerService employeeManagerService = ctx.getBean("employeeManagerService",
				EmployeeManagerService.class);
		Employee employee = createEmployee();
		System.out.println("*************Create Employee Called************");
		employeeManagerService.createEmployee(employee);
		System.out.println("*************Create Employee Completed************");

		System.out.println("*************Get Employee Called************");
		Employee emp = employeeManagerService.getEmployee(2);
		System.out.println(emp.toString());
		System.out.println("*************Get Employee Completed************");

		System.out.println("*************update Employee Called************");
		emp.setName("Praveen Kumar");
		employeeManagerService.updateEmployee(emp);
		System.out.println("*************Update Employee Completed************");

		System.out.println("*************Delete Employee Called************");
		employeeManagerService.deleteEmployee(emp.getId());
		System.out.println("*************Delete Employee Completed************");

		ctx.close();

	}

	private static Employee createEmployee() {
		Employee employee = new Employee();
		employee.setId(3);
		employee.setName("Kapil");
		Address address = new Address();
		address.setId(3);
		address.setCountry("India");
		// setting value more than 20 chars, so that SQLException occurs
		address.setArea("Pune, Baner, Shree Samrudhee 302");
		employee.setAddress(address);
		return employee;
	}
}
