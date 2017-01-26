package com.example.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.PikoService;

@RestController
@RefreshScope
public class PikoRestController {
	@Autowired
	PikoService pikoService;

	@GetMapping("api/v1/piko")
	public String execute() {
		String apple = pikoService.getAppleData();
		String pen = pikoService.getPenData();
		return apple + pen;
	}
}
