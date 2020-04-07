package com.aws.lambda.api;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

@Component
public class HealthApi implements Supplier<Object>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HealthApi.class);

	@Override
	public APIGatewayProxyResponseEvent get() {
		LOGGER.info("com.aws.lambda.api.HealthApi Function Invoked");
		APIGatewayProxyResponseEvent reponse = new APIGatewayProxyResponseEvent();
		reponse.setStatusCode(200);
		reponse.setBody("I am alive and kicking!");
		LOGGER.info("com.aws.lambda.api.HealthApi Function Completed");
		return reponse;
	}

}
