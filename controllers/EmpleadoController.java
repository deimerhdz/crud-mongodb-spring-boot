package com.dhernandez.nomina.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhernandez.nomina.entities.Employee;
import com.dhernandez.nomina.services.EmpleadoService;

@RestController
@RequestMapping("/employees")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/findAll")
	ResponseEntity<List<Employee>> findAll(){
		List<Employee> employees =empleadoService.findAll();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	ResponseEntity<Optional<Employee>> findById(@PathVariable String  id){
		Optional<Employee> empleadoDB = empleadoService.findById(id);
		if(empleadoDB.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(empleadoDB,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	ResponseEntity<?> save(@RequestBody Employee employee){
		
		empleadoService.save(employee);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	ResponseEntity<?> update(@PathVariable String id,@RequestBody Employee employee){
		Optional<Employee> empleadoDB = empleadoService.findById(id);
		if(empleadoDB.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		empleadoService.save(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<?> delete(@PathVariable String id){
		Optional<Employee> empleadoDB = empleadoService.findById(id);
		if(empleadoDB.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		empleadoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
