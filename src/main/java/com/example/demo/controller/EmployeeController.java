package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
@Autowired
EmployeeService service;
@PostMapping("/insert")
public Employee addemployee(@RequestBody Employee e) {
	return this.service.addemployee(e);
}

@DeleteMapping("/delete/{id}")
public String deleteemployee(@PathVariable int id) {
	return this.service.deleteemployee(id);
}
@GetMapping("/getall")
public List<Employee>getall(){
	return this.service.getAll();
	}
@GetMapping("/getbyid/{id}")
public Optional<Employee> getbyid(@PathVariable int id) {
	return this.service.getbyid(id);
}
@PutMapping("/update")
public Employee updateemployee(@RequestBody Employee e) {
	return this.service.updateemployee(e);
}
@GetMapping("/getByEmail/{email}")
public Employee getByEmail(@PathVariable String email) {
	return this.service.getByEmail(email);
}
}
