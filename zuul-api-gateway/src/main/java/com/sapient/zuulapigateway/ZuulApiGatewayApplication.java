package com.sapient.zuulapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.sapient.training.filter.PostFilter;
import com.sapient.training.filter.PreFilter;
import com.sapient.training.filter.PreFilterNew;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	
	@Bean
	public PreFilterNew preFilterNew() {
		return new PreFilterNew();
	}
	
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

}
