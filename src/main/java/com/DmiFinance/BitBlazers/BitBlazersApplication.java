package com.DmiFinance.BitBlazers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.multipart.support.*
//commons.CommonsMultipartResolver;


@SpringBootApplication
@RestController
public class BitBlazersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitBlazersApplication.class, args);
		System.out.println("Helloo DMI Finance");


	}



	@RequestMapping("/qwerty")
	public String q(){
		return "QWERY";
	}

	@RequestMapping(value = "/")
	public String hello(){
		return "Holla!";
	}

	@PostMapping("/text")
	public String processText(@RequestBody String text) {
		// Process the received text
		return "You sent: " + text;
	}

//	@RequestMapping(
//			value = "/process",
//			method = RequestMethod.POST,
//			consumes = "text/plain")
//	public void process1(@RequestBody String payload) throws Exception {
//		System.out.println(payload);
//	}
//
//	@PostMapping(value="/processJson")
//	public void process2(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
//		System.out.println(payload);
//
//	}

//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
//		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//		resolver.setMaxUploadSize(10000000); // Example: 10MB limit
//		return resolver;
//	}

}
