package com.dev.generik.entities.HaloRSA;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter 
@Setter
@Table(name = "WSRIWAYATREG")
public class RiwayatReg {
	@Id
	@Column(name = "Kd")
	private Long kd;

	@Column(name = "Clinic")
	private String clinic;

	@Column(name = "Clinicid")
	private Long clinicid;

	@Temporal(TemporalType.DATE)
	@Column(name = "Date")
	private Date date;

	@Column(name = "Doctorname")
	private String doctorname;

	@Column(name = "ID")
	private Long id;

	@Column(name = "Patientid")
	private String patientid;

	@Column(name = "Patientname")
	private String patientname;

	@Column(name = "Queue")
	private Long queue;

	@Column(name = "Time")
	private String time;

	@Column(name = "Userid")
	private String userid;

	@Column(name = "Star")
	private Long star;

	@Column(name = "Nomer")
	private Long nomer;

	@Column(name = "Simply")
	private Long simply;

	@Temporal(TemporalType.TIME)
	@Column(name = "JAwal")
	private Date jawal;

	@Temporal(TemporalType.TIME)
	@Column(name = "JAkhir")
	private Date jakhir;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Estimasi")
	private Date estimasi;

	@Column(name = "Printed")
	private Long printed;

	@Column(name = "Idol")
	private Long idol;

	@Column(name = "Lab")
	private Long lab;

	@Column(name = "Statustransaksirj")
	private String statustransaksirj;

	@Column(name = "Idstatustransaksirj")
	private Long idstatustransaksirj;

	@Column(name = "Norujukan")
	private String norujukan;

	@Column(name = "Pcr")
	private String pcr;

	@Column(name = "FotoOL")
	private String fotoOL;
	
	@Column(name = "dokterid")
	private String dokterid;
		
	@Column(name = "upx")
	private String upx;

	@Column(name = "Layanan")
	private String layanan;
	
	
		
	
}
