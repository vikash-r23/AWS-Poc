package com.aws.lambda.api;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.aws.lambda.service.EmployeeService;

@Component
public class DeleteEmployee implements Consumer<APIGatewayProxyRequestEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteEmployee.class);

	@Autowired
	EmployeeService service;

	@Override
	public void accept(APIGatewayProxyRequestEvent request) {
		LOGGER.info("com.aws.lambda.api.DeleteEmployee Function Invoked");
		long id = Long.valueOf(request.getBody());
		service.delete(id);
		LOGGER.info("com.aws.lambda.api.DeleteEmployee Function Completed");
	}

}
