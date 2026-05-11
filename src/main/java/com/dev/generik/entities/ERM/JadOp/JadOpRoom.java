package com.dev.generik.entities.ERM.JadOp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter
@Table(name = "WSCBOKELASSTRG")

public class JadOpRoom {
	@Id	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KSTRG")
	private Long id;
	
	@Column(name = "NAMA")
	private String nama;
	
	@Column(name = "ID")
	private Long kelasId;
	
	@Column(name = "ROOMID")
	private Long roomId;
	

}
