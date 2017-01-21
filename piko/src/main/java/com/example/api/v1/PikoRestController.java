package com.example.api.v1;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class PikoRestController {

	@Autowired
    RestTemplate restTemplate;
	
    @Value("${apple.api:http://localhost:3333}")
    URI appleApi;
    
    @Value("${pen.api:http://localhost:4444}")
    URI penApi;
	
	@GetMapping("api/v1/piko")
	public String execute() {
		String apple = getRestData(appleApi, "api/v1/apple");
		String pen = getRestData(penApi, "api/v1/pen");
		return apple + pen;
	}

	private String getRestData(URI uri, String segument) {
		return restTemplate.getForObject(
				UriComponentsBuilder
				.fromUri(uri)
				.pathSegment(segument)
				.build()
				.toUri(),
				String.class);
	}
}
