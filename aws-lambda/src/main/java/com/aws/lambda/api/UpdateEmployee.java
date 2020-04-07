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
public class UpdateEmployee implements Function<Object, Employee> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpdateEmployee.class);

	@Autowired
	EmployeeService service;

	@Override
	public Employee apply(Object request) {
		LOGGER.info("com.aws.lambda.api.UpdateEmployee Function Invoked With Request Body => {}", request);
		Employee emp = new ObjectMapper().convertValue(request, Employee.class);
		emp = service.update(emp);
		LOGGER.info("com.aws.lambda.api.UpdateEmployee Function Completed");
		return emp;
	}

}
