package com.dev.generik.entities.ERM.IGD.SkriningTB;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSERMIGDSKRININGTB")
@Getter
@Setter
public class ERMIGDSkriningTB {
	@Id
	
	private Long id;
	@Temporal(TemporalType.DATE)	
	private Date tanggal;
	private Boolean Batuk;
	private Boolean Rontgen;
	private Boolean Kontak; 
	private String keterangan;
	private String dokter;
	private Boolean dm;
	private Boolean hiv;
	
	

}
