package com.example.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PikoServiceImpl implements PikoService {

	@Autowired
    RestTemplate restTemplate;
	
    @Value("${apple.api:http://localhost:3333}")
    URI appleApi;
    
    @Value("${pen.api:http://localhost:4444}")
    URI penApi;
    
	@Override
	public String getAppleData() {
		return getRestData(appleApi, "api/v1/apple");
	}

	@Override
	public String getPenData() {
		return getRestData(penApi, "api/v1/pen");
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
