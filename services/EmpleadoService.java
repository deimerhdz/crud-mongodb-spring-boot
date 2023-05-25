package com.dhernandez.nomina.services;

import java.util.List;
import java.util.Optional;

import com.dhernandez.nomina.entities.Employee;

public interface EmpleadoService {
	
	List<Employee> findAll();
	
	Optional<Employee> findById(String id);
	
	void save(Employee employee);
	
	void update(Employee employee);
	
	void deleteById(String id);
	
}
