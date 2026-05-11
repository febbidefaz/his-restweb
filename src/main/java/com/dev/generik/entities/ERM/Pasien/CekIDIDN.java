package com.dev.generik.entities.ERM.Pasien;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSCEKIDIDN")
@Getter
@Setter

public class CekIDIDN {

	@Id	
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "IDN")
	private String idn;



	

}
