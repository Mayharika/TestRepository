package com.example.demo.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/*
	 * @GetMapping public String sayWelcome() { return "Welcome back"; }
	 */
	
	@PostMapping
	public Employee saveEmp(@RequestBody Employee employee) {
		System.out.println("EmployeeController.saveEmp()");
		return employeeRepository.save(employee);
		
	}
	
	@PutMapping
	public Employee updateEmp(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
		
	}

	@DeleteMapping
	public String deleteEmp(@RequestParam Integer empId) {
		employeeRepository.deleteById(empId);
		return "record deleted";
		
	}
	
	@GetMapping("/fetchall")
	public List<Employee> getAllEmp(){
		System.out.println("  ***** "+employeeRepository.findAll());
		return employeeRepository.findAll();
		
	}
	
	@GetMapping //?empId=3
	public Employee getAllEmpData(@RequestParam Integer empId){
		System.out.println("========");
		return employeeRepository.findById(empId).get();
		
	}
	
	@GetMapping("/{empId}") // /3;'
	public Employee getAllEmp(@PathVariable Integer empId){
		return employeeRepository.findById(empId).get();
		
	}
	
}
