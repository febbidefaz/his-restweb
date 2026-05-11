package com.dev.generik.entities.ERM.Resep;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ANGKA")
@Getter
@Setter
public class Angka {
	@Id	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILANGAN")
	private Long bilangan;
	
	@Column(name = "ROMAWI")
	private String romawi;	

}
