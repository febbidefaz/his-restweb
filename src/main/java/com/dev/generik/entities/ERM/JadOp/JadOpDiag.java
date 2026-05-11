package com.dev.generik.entities.ERM.JadOp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSCBOPENYAKITBYNAME")
@Getter
@Setter
public class JadOpDiag {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "initialInacbg")
	private String initial;
	
	@Column(name = "nama")
	private String nama;
	

}
