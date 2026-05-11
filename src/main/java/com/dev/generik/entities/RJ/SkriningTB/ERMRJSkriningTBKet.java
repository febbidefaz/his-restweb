package com.dev.generik.entities.RJ.SkriningTB;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SKRININGTBKETERANGAN")
@Getter
@Setter
public class ERMRJSkriningTBKet {
	@Id
	
	private Long id;
	@Temporal(TemporalType.DATE)	
	private String keterangan;


}
