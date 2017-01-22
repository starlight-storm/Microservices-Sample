package com.example.api.v1;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PenRestController {
	
	@GetMapping("api/v1/pen")
	public String execute() {
		return "Pen";
	}
	
}
