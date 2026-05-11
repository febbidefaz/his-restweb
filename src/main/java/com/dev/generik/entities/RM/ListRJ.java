package com.dev.generik.entities.RM;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DAFTARPASIENRAWATJALANRM")
@Getter
@Setter
public class ListRJ {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "REGNUM")
	private String regNum;
	
	@Column(name = "NAMA")
	private String nama;
	
	@Column(name = "ADDR")
	private String addr;
}
