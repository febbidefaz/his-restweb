package com.dev.generik.entities.ERM.IGD.SkriningHPPVK;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSRISIKOHPPADMISINPERSALINAN")
@Getter
@Setter
public class ERMIGDVKHPPView {
	@Id
	private Long id;
	private Long kode;
	@Temporal(TemporalType.DATE)	
	private Date tanggal;
	private String nama;
	private String ketk; 
	private String kat; 
	private String nm; 
	private String ket; 


}
