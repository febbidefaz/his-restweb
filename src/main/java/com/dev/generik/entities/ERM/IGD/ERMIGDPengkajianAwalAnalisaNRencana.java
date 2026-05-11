package com.dev.generik.entities.ERM.IGD;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSERMIGDPENGKAJIANAWALANALISANRENCANA")
@Getter
@Setter
public class ERMIGDPengkajianAwalAnalisaNRencana {
	@Id
	
	private Long id;
	private Long docid;
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	@Temporal(TemporalType.TIME)
	private Date jam;
	private String kepmasalah1; 
	private String kepmasalah2; 
	private String kepdiagnosa1; 
	private String kepdiagnosa2; 
	private String kephasil; 
	private String medlab; 
	private String medrontgen; 
	private String medecg; 
	private String medlainnya; 
	private String meddiagnosakerja; 
	private String meddiagnosabanding; 
	private String medterapi;
	private String medtindakan; 
	private String medhasil;

	
	

}
