package com.dev.generik.entities.ERM.Billing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "WSVISITRAWATINAP")
@Getter 
@Setter
public class RekOperasi {
	 @Id	
	 @Column(name = "IDD")
	 private Long idd;
	 
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "NAMA_JENIS")
	 private String namajenis;
	 	 		 
	 @Column(name = "BIAYA")
	 private Long biaya;
		 
	 @Column(name = "POT")
	 private Float pot;
	 
	 @Column(name = "C")
	 private Long c;
	 
	
	 
}
