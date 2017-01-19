package com.example.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppleRestController {

	@GetMapping("api/v1/apple")
	public String execute() {
		return "Apple";
	}
}
