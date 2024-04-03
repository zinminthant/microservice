package com.xyzxc.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyzxc.limitsservice.bean.Limits;
import com.xyzxc.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits retrieveLimist() {
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}
}
