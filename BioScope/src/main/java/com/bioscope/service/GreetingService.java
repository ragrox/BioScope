package com.bioscope.service;

import org.springframework.stereotype.Service;

@Service("greetingService")
public class GreetingService {

 public String sayHello() {
  return "Hello from Greeting Service";
 }
 
}