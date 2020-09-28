package com.sapient.training.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class PreFilterNew extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("In PreFilterNew");
		return null;
	}

	@Override
	public String filterType() {		
		return "pre";
	}

	@Override
	public int filterOrder() {
			return 1;
	}

}