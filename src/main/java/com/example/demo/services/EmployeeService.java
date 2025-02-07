package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired
EmployeeRepository repo;


public Employee addemployee(Employee e) {
	return this.repo.save(e);
}
public String deleteemployee(int id) {
	this.repo.deleteById(id);
	return "deleted successfully:"+id;
}
public List<Employee>getAll(){
	return (List<Employee>) this.repo.findAll();
}
public Optional<Employee> getbyid(int id) {
	return this.repo.findById(id);
}
public Employee updateemployee(Employee e) {
	int id=e.getId();
	Employee emp =repo.findById(id).get();
	emp.setName(e.getName());
	emp.setEmail(e.getEmail());
	emp.setPassword(e.getPassword());
	emp.setMobilenumber(e.getMobilenumber());
	return this.repo.save(emp);
}
public Employee getByEmail(String email) {
	return this.repo.getByEmail(email);
}
}
