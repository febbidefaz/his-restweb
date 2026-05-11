package com.dev.generik.entities.RJ.SkriningTB;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSERMIGDSKRININGTBRJ")
@Getter
@Setter
public class ERMRJSkriningTB {
	@Id
	
	private Long id;
	@Temporal(TemporalType.DATE)	
	private Date tanggal;
	private Boolean batuk;
	private Boolean sesak;
	private Boolean beratbadan; 
	private Boolean riwayat; 
	private String keterangan;
	private String dokter;
	private Boolean dm;
	private Boolean hiv;
	
	

}
