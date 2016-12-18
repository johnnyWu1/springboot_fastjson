package com.jonney;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	SpringUtils springUtils;
	
	@GetMapping("/hello")
	Object sayHello(){
		return "Hello haha";
	}
	
}
