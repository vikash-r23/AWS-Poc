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
public class GetEmployee implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetEmployee.class);

	@Autowired
	EmployeeService service;

	@Override
	public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {
		LOGGER.info("com.aws.lambda.api.GetEmployee Function Invoked");
		long id = Long.valueOf(request.getBody());
		Employee emp = service.findbyId(id);
		Gson gson = new Gson();
		APIGatewayProxyResponseEvent reponse = new APIGatewayProxyResponseEvent();
		reponse.setStatusCode(200);
		reponse.setBody(gson.toJson(emp));
		LOGGER.info("com.aws.lambda.api.GetEmployee Function Completed");
		return reponse;
	}

}
