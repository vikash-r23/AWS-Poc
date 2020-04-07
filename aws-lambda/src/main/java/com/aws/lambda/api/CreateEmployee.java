package com.aws.lambda.api;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.aws.lambda.entity.Employee;
import com.aws.lambda.service.EmployeeService;
import com.google.gson.Gson;

@Component
public class CreateEmployee implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateEmployee.class);

	@Autowired
	EmployeeService service;

	@Override
	public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {
		LOGGER.info("com.aws.lambda.api.CreateEmployee Function Invoked");
		Gson gson = new Gson();
		Employee emp = gson.fromJson(request.getBody(), Employee.class);
		emp = service.save(emp);
		APIGatewayProxyResponseEvent reponse = new APIGatewayProxyResponseEvent();
		reponse.setStatusCode(200);
		reponse.setBody(gson.toJson(emp));
		LOGGER.info("com.aws.lambda.api.CreateEmployee Function Completed");
		return reponse;
	}

}
