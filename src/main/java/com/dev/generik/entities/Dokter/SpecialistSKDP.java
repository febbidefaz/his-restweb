package com.dev.generik.entities.Dokter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WSSPECIALIST")
public class SpecialistSKDP {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Name")
	private String name;
	
	@Column(name = "KDBPJS")
	private String kdBPJS;

	

}
