package com.dev.generik.entities.Gizi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSLOGGIZIPRODUCT")
@Getter
@Setter
public class LogGiziProduct {
	@Id	
	private String kode;
	private String nama;
	private String satuan;
	private Long hpp;
	private Long hj;
	private Long stock;
}
