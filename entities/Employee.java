package com.dhernandez.nomina.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
public class Employee {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String identification;
	@NotEmpty
	private String name;
	@NotEmpty
	private String telephone;
	@NotEmpty
	@Indexed(unique = true)
	
	private String email;
	@NotEmpty
	private Integer hourNumber;
	@NotEmpty
	private BigDecimal hourPrice;
	
	private BigDecimal salary;
	
	private LocalDateTime createdAt;
	
	public BigDecimal calculateSalary() {
		return hourPrice.multiply(BigDecimal.valueOf(hourNumber));
	}

}
