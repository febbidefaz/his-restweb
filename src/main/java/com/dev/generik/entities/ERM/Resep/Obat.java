package com.dev.generik.entities.ERM.Resep;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSOBAT")
@Getter
@Setter
public class Obat {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KODE")
	private String kode;
	
	@Column(name = "NAMA")
	private String nama;	
	
	@Column(name = "HARGA")
	private Long harga;	
	
	@Column(name = "GENERIKNAME")
	private String generik;	
	
	@Column(name = "RACIKAN")
	private Boolean racikan;
	
	@Column(name = "DOSIS")
	private Long dosis;
	
	@Column(name = "SATUAN")
	private String dosisSatuan;	
    	
}
