package com.examples.spring.boot.rest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.examples.spring.boot.rest.model.Employee;
import com.examples.spring.boot.rest.repository.EmployeeRepository;
import com.examples.spring.boot.rest.service.EmployeeService;import ch.qos.logback.core.net.SyslogOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTests {

	@Autowired
	EmployeeService empService;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAddEmployee()
	{
		Employee emp = new Employee();
		emp.setName("Abdul");
		emp.setAge(25);
		emp.setAddress("Bengaluru");
		emp.setDepartment("Admin");
		
		empService.add(emp);
		
		assertEquals(1, empService.list().size());
	}
	
	@Test
	public void testUpdateEmployee()
	{
		Employee emp = new Employee();
		emp.setName("Abdul");
		emp.setAge(25);
		emp.setAddress("Bengaluru");
		emp.setDepartment("IT");
		
		empService.add(emp);
		
		// update employee
		emp.setName("Mick");
		empService.update(emp);
		
		assertEquals("Mick", empService.get(emp.getId()).getName());		
	}
	
	@Test
	public void testFindByDepartment()
	{
		Employee emp = new Employee();
		emp.setName("Abdul");
		emp.setAge(25);
		emp.setAddress("Bengaluru");
		emp.setDepartment("IT");
		emp.setCountry("India");
		empService.add(emp);
		
		emp = new Employee();
		emp.setName("Zahoor");
		emp.setAge(25);
		emp.setAddress("Bengaluru");
		emp.setDepartment("Admin");
		emp.setCountry("India");
		empService.add(emp);
		
		// Sorting 
		List<Employee> employees = empRepo.findAll(new Sort(Direction.DESC, "name"));
		employees.forEach(System.out::println);
		
		// Paging
		Page<Employee> employeesPaged = empRepo.findAll(new PageRequest(0, 10));
		employeesPaged.getContent().forEach(System.out::println);
	}

}
