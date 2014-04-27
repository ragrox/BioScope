package com.bioscope.endpoints;


import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.bioscope.service.GreetingService;


@WebService(serviceName="GreetingService")
public class GreetingServiceEndpoint {

 @Autowired
 private GreetingService greetingService;
 
 @WebMethod
 public String sayHello() {
  return greetingService.sayHello();
 }
 
}
