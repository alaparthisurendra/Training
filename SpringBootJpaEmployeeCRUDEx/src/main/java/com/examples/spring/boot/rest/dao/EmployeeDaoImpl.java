package com.examples.spring.boot.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.examples.spring.boot.rest.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void addEmployee(Employee emp)
	{
		entityManager.persist(emp);
	}
	
	public void updateEmployee(Employee emp)
	{
		entityManager.merge(emp);
		System.out.println("Employee updated");
	}
	
	public List<Employee> listEmployees()
	{
		List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
		return employees;
	}
	
	public Employee getEmployeeById(int id)
	{
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}
	
	public void removeEmployee(int id)
	{
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
	}

}
