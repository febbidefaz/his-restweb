package com.dev.generik.entities.ERM.Billing;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "WSVISITRAWATINAP")
@Getter 
@Setter
public class RekObat {
	 @Id	
	 @Column(name = "IDD")
	 private Long idd;
	 
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "INVOICE DATE")
	 private LocalDate date;
	 	 		 
	 @Column(name = "HUTANGOBAT")
	 private Float hutangobat;

	
	 
}
