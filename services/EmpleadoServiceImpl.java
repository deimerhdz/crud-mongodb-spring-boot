package com.dhernandez.nomina.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhernandez.nomina.entities.Employee;
import com.dhernandez.nomina.exceptions.UniqueException;
import com.dhernandez.nomina.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	Log LOG = LogFactory.getLog(EmpleadoServiceImpl.class);
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Employee> findAll() {
		LOG.info("Accediendo al metodo findAll()");
		List<Employee> empleados = empleadoRepository.findAll();
		LOG.info("Saliendo al metodo findAll()");
		return empleados;
	}

	@Override
	public Optional<Employee> findById(String id) {
		LOG.info("Accediendo al metodo findById(String id) "+id);
		 Optional<Employee> empleadoDB = empleadoRepository.findById(id);
		LOG.info("Saliendo al metodo findById()");
		return empleadoDB;
	}

	@Override
	public void save(Employee employee) {
		LOG.info("Accediendo al metodo save(Employee employee) "+employee);
	
		employee.setSalary(employee.calculateSalary());
		employee.setCreatedAt(LocalDateTime.now());
		empleadoRepository.save(employee);
		LOG.info("Saliendo al metodo save()");
		
	}

	@Override
	public void deleteById(String id) {
		LOG.info("Accediendo al metodo deleteById(String id) "+id);
		empleadoRepository.deleteById(id);
		LOG.info("Saliendo al metodo deleteById()");
	}

	@Override
	public void update(Employee employee) {
		
	}

	

}
