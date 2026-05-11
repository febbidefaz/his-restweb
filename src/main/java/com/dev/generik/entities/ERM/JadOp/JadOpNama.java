package com.dev.generik.entities.ERM.JadOp;

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
public class JadOpNama {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kodeJenis")
	private Long id;
	
	@Column(name = "namaJenis")
	private String nama;
	

}
