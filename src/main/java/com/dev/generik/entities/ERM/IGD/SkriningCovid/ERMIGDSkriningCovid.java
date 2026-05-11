package com.dev.generik.entities.ERM.IGD.SkriningCovid;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSERMIGDSKRININGCOVID")
@Getter
@Setter
public class ERMIGDSkriningCovid {
	@Id
	
	private Long id;
	@Temporal(TemporalType.DATE)	
	private Date tanggal;
	private Long skortandangejala;
	private Long skorriwayat; 
	private Long skordemam; 
	private Long skorusia; 
	private Long skorkel; 
	private Long skorsuhu; 
	private Long skorgejala; 
	private Long skorratio; 
	private Long jml;
	private String dokter;

	
	

}
