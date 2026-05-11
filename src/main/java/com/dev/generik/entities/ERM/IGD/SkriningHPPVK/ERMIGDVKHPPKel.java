package com.dev.generik.entities.ERM.IGD.SkriningHPPVK;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RISIKOHPPADMISINPERSALINANKEL")
@Getter
@Setter
public class ERMIGDVKHPPKel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nama;
	private String ket;
	private String kat;


}
