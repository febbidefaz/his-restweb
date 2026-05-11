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
@Table(name = "WSERMIGDPENGKAJIANAWALNYERI")
@Getter
@Setter
public class ERMIGDPengkajianAwalNyeri {
	@Id
	
	private Long id;
	private Long docid;
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	@Temporal(TemporalType.TIME)
	private Date jam;
	private Long apakahadanyeri;
	private Long serangan; 
	private Long provocating; 
	private Long quality; 
	private String region; 
	private Long Severate; 
	private Long Time; 
	private String Timetext;
		
	

}
