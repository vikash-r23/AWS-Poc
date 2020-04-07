package com.aws.lambda.api;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aws.lambda.entity.Employee;
import com.aws.lambda.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CreateEmployee implements Function<Object, Employee> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateEmployee.class);

	@Autowired
	EmployeeService service;

	@Override
	public Employee apply(Object request) {
		LOGGER.info("com.aws.lambda.api.CreateEmployee Function Invoked With Request Body => {}", request);
		Employee emp = new ObjectMapper().convertValue(request, Employee.class);
		emp = service.save(emp);
		LOGGER.info("com.aws.lambda.api.CreateEmployee Function Completed");
		return emp;
	}

}
