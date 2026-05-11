package com.dev.generik.entities.RJ.Operasi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "JENIS_OP")
//@Table(name = "WSLABHASILBATAS1")
@Getter
@Setter
public class Operasi {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KODE_JENIS")
	private Long id;
	
	@Column(name = "NAMA_JENIS")
	private String nama;
	

	
}
