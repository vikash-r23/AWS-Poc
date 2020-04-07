package com.aws.lambda.api;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aws.lambda.service.EmployeeService;

@Component
public class DeleteEmployee implements Consumer<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteEmployee.class);

	@Autowired
	EmployeeService service;

	@Override
	public void accept(String id) {
		LOGGER.info("com.aws.lambda.api.DeleteEmployee Function Invoked With Request Body => {}",id);
		long empId = Long.valueOf(id);
		service.delete(empId);
		LOGGER.info("com.aws.lambda.api.DeleteEmployee Function Completed");
	}

}
