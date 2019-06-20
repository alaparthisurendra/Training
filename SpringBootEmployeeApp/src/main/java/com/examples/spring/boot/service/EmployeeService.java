package com.examples.spring.boot.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.examples.spring.boot.model.Employee;

@Component
public class EmployeeService {


	private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	
	public EmployeeService() {

	}
	
	public boolean add(Employee employee) {
		employee.setId(employees.size() + 1);
		employees.put(employee.getId(), employee);
		return true;
	}

	public Employee get(int id) {
		return employees.get(id);
	}

	public Collection<Employee> getAll() {
		return employees.values();
	}

	public boolean update(Employee employee) {
		employees.put(employee.getId(), employee);
		return true;
	}

	public boolean delete(Employee employee) {
		employees.remove(employee.getId());
		return true;
	}

	// Get Employee count greater than given age
	public long getEmployeeCountAgeGreaterThan(int age) {
		return this.getAll().stream().filter(emp -> emp.getAge() > age).count();
	}

	// Get list of Employee IDs whose age is greater than given age
	public List<Integer> getEmployeeIdsAgeGreaterThan(int age) {
		return this.getAll().stream().filter(emp -> emp.getAge() > age).map(emp -> emp.getId())
				.collect(Collectors.toList());
	}

	
	// Get Department wise Employee count
	public Map<String, Long> getEmployeeCountByDepartment() {

		return this.getAll().stream()
				// .parallelStream()
				.map(Employee::getDepartment) // output -> Department name
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				// Key - Department name
				// Value - Count
	}
	
	
	// Get Department wise Employee count ordered by Department name
	public Map<String, Long> getEmployeeCountByDepartmentOdered() {
		return this.getAll()
				.stream()
				.sorted(Comparator.comparing(Employee::getDepartment))
				.collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.counting()));
				// List employee names by Department
				// .collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.mapping(Employee::getName, Collectors.toList())));
	}
	
	// Get Department wise average Employee age ordered by Department name
	public Map<String, Double> getAvgEmployeeAgeByDept() {
		return this.getAll()
				.stream()
				.sorted(Comparator.comparing(Employee::getDepartment))
				.collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.averagingInt(Employee::getAge)));
	}
	
	// Get Departments have more than given Employee count
	public List<String> getDepartmentsHaveEmployeesMoreThan(int criteria)
	{
		//List<String> deptList = new ArrayList<>();
		
		return this.getAll()
				.stream()
				.sorted(Comparator.comparing(Employee::getDepartment))
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
				//.forEach((k,v) -> {if(v > criteria) {deptList.add(k);}});
				// return deptList;
				
				.entrySet().stream()	// Creating one more stream to filter the output
				.filter(entry -> entry.getValue() > criteria)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());			
	}
	
	// Get Employee names starting with given string
	public List<String> getEmployeeNamesStartsWith(String prefix) {
		return this.getAll()
				.stream()
				.filter(emp -> emp.getName().startsWith(prefix))
				.map(emp -> emp.getName())
				.collect(Collectors.toList());
	}	
}
