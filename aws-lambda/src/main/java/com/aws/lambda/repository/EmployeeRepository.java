package com.aws.lambda.repository;

import org.springframework.data.repository.CrudRepository;

import com.aws.lambda.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
