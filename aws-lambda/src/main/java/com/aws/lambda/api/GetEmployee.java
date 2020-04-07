package com.aws.lambda.api;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aws.lambda.entity.Employee;
import com.aws.lambda.service.EmployeeService;

@Component
public class GetEmployee implements Function<String, Employee> {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetEmployee.class);

	@Autowired
	EmployeeService service;

	@Override
	public Employee apply(String id) {
		LOGGER.info("com.aws.lambda.api.GetEmployee Function Invoked With Request Body => {}", id);
		long empId = Long.valueOf(id);
		Employee emp = service.findbyId(empId);
		LOGGER.info("com.aws.lambda.api.GetEmployee Function Completed");
		return emp;
	}

}
