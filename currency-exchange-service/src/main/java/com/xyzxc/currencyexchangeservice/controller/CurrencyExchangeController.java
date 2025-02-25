package com.xyzxc.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xyzxc.currencyexchangeservice.bean.CurrencyExchange;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to) {
		
		logger.info("retrieveExchangeValue -- {}-- {}",from,to);
		
//		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
//		
//		if(currencyExchange ==null) {
//			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
//		}

		CurrencyExchange currencyExchange=new CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
		
	}
}
