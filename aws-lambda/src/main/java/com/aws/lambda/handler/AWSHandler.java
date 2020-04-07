package com.aws.lambda.handler;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.aws.lambda.entity.Employee;

public class AWSHandler extends SpringBootRequestHandler<Object, Employee>{

}
