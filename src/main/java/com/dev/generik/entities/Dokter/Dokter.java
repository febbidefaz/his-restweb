package com.dev.generik.entities.Dokter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "WSDOKTER")
@Getter
@Setter
public class Dokter {
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "Dokter")
	private String dokter;

	@Column(name = "Spesialis")
	private String spesialis;

	@Column(name = "Sp")
	private Long sp;	
	
}
