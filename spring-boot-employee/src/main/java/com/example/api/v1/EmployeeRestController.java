package com.example.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.business.domain.Employee;
import com.example.business.service.EmployeeService;

import lombok.val;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	// Advance REST ClientでURLにhttp://localhost:8080/api/v1/employees/, POST,
	// Row Payloadに入力データを設定（ex: {"name":"斎藤", "mail":"saito@sample.jp"} ）
	@PostMapping
	public ResponseEntity<Employee> create(@RequestBody Employee emp, UriComponentsBuilder uriBuilder) {
		
		employeeService.create(emp);

        val location = uriBuilder
        		.path("api/v1/employees/{id}")
                .buildAndExpand(emp.getId())
                .toUri();

        return ResponseEntity
        		.created(location)
        		.body(emp);
	}
	
	// Advance REST ClientでURLにhttp://localhost:8080/api/v1/employees/, GET,
	@GetMapping
	public List<Employee> findAll() {
		val employees = employeeService.findAll();
        return employees;
	}
	
	// Advance REST ClientでURLにhttp://localhost:8080/api/v1/employees/{0|1}, GET
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Employee findById(@PathVariable int id) {
		val emp = employeeService.findById(id);
		return emp;
	}
}
