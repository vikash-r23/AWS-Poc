package com.aws.lambda.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.lambda.entity.Employee;
import com.aws.lambda.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	/**
	 *  Find Employee by ID
	 * @param id
	 * @return
	 */
	public Employee findbyId(long id) {
		Optional<Employee> emp = repository.findById(id);
		if (!emp.isPresent()) {
			throw new EntityNotFoundException("Employee with id " + id + " does not exist");
		}
		return emp.get();
	}

	/**
	 * Create new Employee
	 * @param emp
	 * @return
	 */
	public Employee save(Employee emp) {
		return repository.save(emp);
	}
	
	/**
	 * Update an existing Employee
	 * @param emp
	 * @return
	 */
	public  Employee update(Employee emp) {
		Optional<Employee> existingEmp = repository.findById(emp.getId());
		if (!existingEmp.isPresent()) {
			throw new EntityNotFoundException("Employee with id " + emp.getId() + " does not exist");
		}
		return save(emp);
	}
	
	/**
	 * Delete an Employee
	 * @param id
	 */
	public void delete(long id) {
		repository.deleteById(id);
	}
}
