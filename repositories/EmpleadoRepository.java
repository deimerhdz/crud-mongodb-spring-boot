package com.dhernandez.nomina.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dhernandez.nomina.entities.Employee;

public interface EmpleadoRepository extends MongoRepository<Employee, String>{
	boolean existsByEmail(String email);
	
	boolean existsByIdentification(String identification);
}
