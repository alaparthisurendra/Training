package com.examples.spring.boot.rest.dao;

import java.util.List;

import com.examples.spring.boot.rest.model.Employee;

public interface EmployeeDAO {

	public void save(Employee emp);

	public List<Employee> findAll();

	public Employee findById(Object id);

	public void update(Employee emp);

	public void delete(Employee emp);
}
