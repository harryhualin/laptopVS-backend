package com.mercury.laptapVS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LaptapVsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaptapVsApplication.class, args);
		System.out.println("**************");	
		System.out.println("app start-------------");	
		System.out.println("**************");	
	}
	
	
	@GetMapping("/")
	public String test() {
		return "test success";
		
	}
}
