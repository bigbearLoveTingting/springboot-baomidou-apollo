package com.greatwall.business.controller.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/apollo")
public class ApolloController {
	@Value("${test_apollo:Apollo}")
	private String test_apollo;
	
	@RequestMapping("/getTestApollo")
	@ResponseBody
	public String getTestApollo(){
		return test_apollo;
	}
}
