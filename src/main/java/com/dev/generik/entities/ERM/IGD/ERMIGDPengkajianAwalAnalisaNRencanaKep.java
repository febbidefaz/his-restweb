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
@Table(name = "WSERMIGDPENGKAJIANAWALANALISANRENCANAKEP")
@Getter
@Setter
public class ERMIGDPengkajianAwalAnalisaNRencanaKep {
	@Id
	
	private Long id;
	private Long no;
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	@Temporal(TemporalType.TIME)
	private Date jam;
	private String rencanakep; 
	private String perawat; 

}
