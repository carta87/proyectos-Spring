package com.curso.spring.wather.forecast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather-forescast")
public class WeatherForecastController {
	
	@GetMapping("/findByDate/{date}")
	public Float getTemperatureByDate(@PathVariable String date) {
		//TODO tafur Pendiente realizar la implementacion metodo de encontar temperatura por fecha
		return 0.0F; 
	}

}
