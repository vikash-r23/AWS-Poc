package com.aws.lambda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.lambda.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
