package com.examples.spring.boot.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examples.spring.boot.rest.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
