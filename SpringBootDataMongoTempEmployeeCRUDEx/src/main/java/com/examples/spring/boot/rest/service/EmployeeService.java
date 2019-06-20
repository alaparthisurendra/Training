package com.examples.spring.boot.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.spring.boot.rest.dao.EmployeeDAO;
import com.examples.spring.boot.rest.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDao;

	public void add(Employee employee) {
		employeeDao.save(employee);
	}

	public void update(Employee employee) {
		employeeDao.save(employee);
	}

	public Employee get(String empId) {
		return employeeDao.findById(empId);
	}

	public void delete(String empId) {
		employeeDao.delete(employeeDao.findById(empId));
	}

	public List<Employee> list() {
		List<Employee> employees = new ArrayList<>();
		for (Employee employee : employeeDao.findAll()) {
			employees.add(employee);
		}
		return employees;
	}

}
