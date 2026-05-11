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
@Table(name = "WSERMIGDPENGKAJIANAWALDISCHARGEPLANNING")
@Getter
@Setter
public class ERMIGDPengkajianAwalDischargePlanning {
	@Id
	
	private Long id;
	private Long docid;
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	@Temporal(TemporalType.TIME)
	private Date jam;
	private Long umur65;
	private Long keterbatasanmobilitas; 
	private Long perawatanataupengobatanlanjutan; 
	private Long bantuanuntukmelakukan; 
	private Long bilasalah;
	private Long kesimpulan; 
	private Date kesimpulantgl; 
	private Date kesimpulanjam; 
	private String konkluarkeadaanumum; 
	private Float suhu;
	private Long nadi; 
	private Long sistole; 
	private Long diastole; 
	private Long nafas; 
	private Long kesadaran; 
	private Long gcs; 
	private Long spo2; 
	private Boolean renrj; 
	private Date renrjjam; 
	private Date renrjtgl; 
	private Long renrjke; 
	private Boolean renmasukrs; 
	private String renmasukrstext; 
	private Boolean rendirujuk; 
	private String rendirujuktext; 
	private Boolean renaps; 
	private String renapstext; 
	private Boolean meninggal; 
	private String perawat; 
	private Long dokter;


	
	

}
