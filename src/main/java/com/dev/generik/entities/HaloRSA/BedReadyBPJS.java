package com.dev.generik.entities.HaloRSA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "WSBEDREADYBPJS")
public class BedReadyBPJS {
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "koderuang")
	private Long koderuang;

	@Column(name = "kodekelas", length = 20)
	private String kodekelas;

	@Column(name = "kapasitas")
	private Long kapasitas;

	@Column(name = "tersedia")
	private Long tersedia;
	
	@Column(name = "tersediapria")
	private Long tersediapria;

	@Column(name = "tersediawanita")
	private Long tersediawanita;

	@Column(name = "tersediapriawanita")
	private Long tersediapriawanita;


	@Column(name = "namaruang", length = 20)
	private String namaruang;

	
}
