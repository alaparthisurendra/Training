package com.examples.spring.boot.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.examples.spring.boot.rest.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void save(Employee emp) {
		mongoTemplate.insert(emp);
	}

	@Override
	public List<Employee> findAll() {
		return mongoTemplate.findAll(Employee.class);
	}

	@Override
	public Employee findById(Object id) {
		return mongoTemplate.findById(id, Employee.class);
	}

	@Override
	public void update(Employee emp) {
		// TO BE FIXED
//		mongoTemplate.updateFirst(new Query(Criteria.where("id").is(emp.getId())),
//				new Update().push("Department", "Quality"), Employee.class);
	}

	@Override
	public void delete(Employee emp) {
		mongoTemplate.remove(emp);
	}

}
