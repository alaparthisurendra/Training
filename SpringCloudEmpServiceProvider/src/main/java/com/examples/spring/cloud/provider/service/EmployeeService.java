package com.examples.spring.cloud.provider.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.examples.spring.cloud.provider.model.Employee;


@Service
public class EmployeeService {

	private static Map<String, Employee> employees = new LinkedHashMap<String, Employee>();

	public String add(Employee employee) {

		employee.setId(UUID.randomUUID().toString());

		employees.put(employee.getId(), employee);
		
		return employee.getId();
	}

	public void update(Employee employee) {

		employees.put(employee.getId(), employee);
	}

	public Employee get(String empId) {
		return employees.get(empId);
	}

	public void delete(String empId) {
		employees.remove(empId);
	}

	public List<Employee> list() {
		return new ArrayList<Employee>(employees.values());
	}

}
