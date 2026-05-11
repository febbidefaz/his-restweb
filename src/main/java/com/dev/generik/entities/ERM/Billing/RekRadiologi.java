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
public class RekRadiologi {
	 @Id	
	 @Column(name = "IDD")
	 private Long idd;
	 
	 @Column(name = "ID")
	 private Long id;
	 	 		 
	 @Column(name = "BIAYARAD")
	 private Long biayarad;
	 
	 @Column(name = "TRAD")
	 private LocalDate trad;
		 
	 @Column(name = "DISCOUNT")
	 private Float discount;
	 
	 @Column(name = "PERIKSA")
	 private String periksa;
	 
}
