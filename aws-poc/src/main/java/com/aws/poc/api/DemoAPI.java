package com.aws.poc.api;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.aws.poc.service.DynamoDBService;

@Component
public class DemoAPI implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	@Autowired
	DynamoDBService service;

	@Override
	public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {
		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
		response.setStatusCode(200);
		response.setBody(String.format(
				"Hello %s ! This is a demo api for serverless programming using Spring Boot + AWS Lambda + API Gateway + DynamoDB",
				request.getBody()));
		return response;
	}

}
