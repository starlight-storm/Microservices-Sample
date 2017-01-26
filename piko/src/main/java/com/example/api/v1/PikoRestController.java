package com.example.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.PicoService;

@RestController
@RefreshScope
public class PikoRestController {
	
	@Autowired
	PicoService picoService;
	
	@GetMapping("api/v1/piko")
	public String execute() {
		String appleData = picoService.getAppleData();
		String penData = picoService.getPenData();
		
		return appleData + penData;
	}
}
