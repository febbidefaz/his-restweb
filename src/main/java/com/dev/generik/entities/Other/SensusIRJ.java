package com.dev.generik.entities.Other;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "WSLABHASILBATAS1")
@Getter
@Setter
public class SensusIRJ {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDSENSUSIRJ")
	private Long id;
	
	@Column(name = "SENSUSIRJ")
	private String sensus; 
		
}
