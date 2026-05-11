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
public class RekLain {
	 @Id	
	 @Column(name = "IDD")
	 private Long idd;
	 
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "LAIN")
	 private String lain;
	 	 		 
	 @Column(name = "BIAYA")
	 private Long biaya;
		 
	 @Column(name = "DISCOUNT")
	 private Float discount;
	 
	
	 
}
