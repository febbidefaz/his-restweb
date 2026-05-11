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
@Table(name = "WSERMIGDPENGKAJIANAWALKEP")
@Getter
@Setter
public class ERMIGDPengkajianAwalKep {
	@Id
	
	private Long id;
	private Long docid;
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	@Temporal(TemporalType.TIME)
	private Date Jamdatang;
	@Temporal(TemporalType.TIME)
	private Date jam;
	private Long kepAnamnese;
	private Long b1batuk;
	private Long b1Iramanafas; 
	private Long b1Ipolapernafasan;
	private Long b1suaranafas;
	private Long b1suaranafastext; 
	private Long b1alatbantunafas;
	private Long b2nyeridada; 
	private Long b2pendarahan;
	private String b2pendarahantext;
	private Long b2akral; 
	private Long b2crt;
	private String b3gcs;
	private Long b3kesadaran;
	private Long b3reflekcahaya;
	private Long b3kelumpuhan;
	private Long b3pusing;
	private Long b3pupil; 
	private String b4bak;
	private String b4produksiurine;
	private Long b4produksiurinewarna;
	private String b4produksiurinewarnabau;
	private Long b4gangguan;
	private String b4gangguantext;
	private Long b4alatbantu;
	private String b4alatbantutext;
	private String b5babperhari; 
	private String b5babkonsistensi;
	private String b5babkonsistensiwarna;
	private Long b5bab;
	private Long b5abdomen;
	private String b5abdomenperistatik; 
	private String b5abdomentext;
	private Long b5nyeritekan;
	private Long b5jejasabdomen; 
	private Long b6pergerakansendi;
	private String b6pergerakansenditext; 
	private Long b6dislokasi; 
	private Long b6fraktur; 
	private Long b6luka; 
	private Long b6turgor; 
	private Long b6oedema; 
	private String b6oedemalokasi1;
	private String b6oedemalokasi2; 
	private String b6oedemalokasi3; 
	private String b6oedemalokasi4; 
	private String b6kekuatanotot1; 
	private String b6kekuatanotot2; 
	private String b6kekuatanotot3; 
	private String b6kekuatanotot4; 
	private String b6lainlain;

	
	

}
