package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeEntity;
import com.employee.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;

	@PostMapping("/employees")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity e) {
		return employeeservice.createEmployee(e);
	}

	@GetMapping("/employees")
	public List<EmployeeEntity> getAllEmployye() {
		return employeeservice.getAllEmployee();
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		boolean deleted = false;
		deleted = employeeservice.deleteEmployee(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", deleted);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
		EmployeeEntity employee = null;
		employee = employeeservice.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity e) {

		e = employeeservice.updateEmployee(id, e);
		return ResponseEntity.ok(e);
	}
}
