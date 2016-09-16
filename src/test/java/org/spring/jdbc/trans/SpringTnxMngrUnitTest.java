package org.spring.jdbc.trans;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.spring.jdbc.trans.dao.EmployeeDAO;
import org.spring.jdbc.trans.model.Address;
import org.spring.jdbc.trans.model.Employee;
import org.spring.jdbc.trans.service.EmployeeManagerService;
import org.spring.jdbc.trans.service.EmployeeManagerServiceImpl;

/*Stubbing means simulating the behavior of a mock object’s method.
 *  We can stub a method on a mock object by setting up an expectation
 *   on the method invocation.*/
@RunWith(MockitoJUnitRunner.class)
public class SpringTnxMngrUnitTest {

	@Mock
	EmployeeDAO employeeDao;

	@InjectMocks
	EmployeeManagerService employeeManagerService = new EmployeeManagerServiceImpl();
	
	@Test
	public void testMockCreation(){
		assertNotNull(employeeDao);
	}

	@Test
	public void insertEmployee() {
		List<Employee> eList = getEmpList();

		when(employeeDao.getAllEmployees()).thenReturn(eList);
		assertNotNull(employeeDao.getAllEmployees());
		assertEquals(2,employeeDao.getAllEmployees().size());
	}

	private static List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<Employee>();

		Employee employee = new Employee();
		employee.setId(4);
		employee.setName("Kapil");
		Address address = new Address();
		address.setId(4);
		address.setCountry("India");
		// setting value more than 50 chars, so that SQLException occurs
		address.setArea("Pune, Baner, Shree Samrudhee 302");
		employee.setAddress(address);

		Employee employee1 = new Employee();
		employee.setId(5);
		employee.setName("Manjul");
		Address address1 = new Address();
		address.setId(5);
		address.setCountry("India");
		// setting value more than 50 chars, so that SQLException occurs
		address.setArea("Pune, Baner, Shree Samrudhee 302");
		employee.setAddress(address1);

		empList.add(employee);
		empList.add(employee1);
		return empList;

	}
}
