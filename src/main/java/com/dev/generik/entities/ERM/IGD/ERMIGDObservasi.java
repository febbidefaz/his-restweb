package com.dev.generik.entities.ERM.IGD;

//import java.sql.Date;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSERMIGDOBSERVASI")
@Getter
@Setter
public class ERMIGDObservasi {
	@Id
	
	private Long id;
	private Long no;
	@Temporal(TemporalType.TIME)
//	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date jam; 
	@Temporal(TemporalType.DATE)
//	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT+7", lenient = OptBoolean.FALSE)

	private Date tgl; 
	private String infus; 
	private String obat; 
	private String nebulizer; 
	private String suction; 
	private Long sistol; 
	private Long diastol; 
	private Long nadi; 
	private Float suhu; 
	private Long rr; 
	private String O2; 
	private Long spO2; 
	private Long gcs; 
	private Long gda; 
	private Long tb; 
	private Float bb; 
	private Long pupil; 
	private Float sonde; 
	private Float minum; 
	private String makan; 
	private Float urine; 
	private Float darah; 
	private Float muntahngt; 
	private Float faeces; 
	private Float drain; 
	private Float mode; 
	private Float tidal; 
	private Float mvtv; 
	private Float tri; 
	private Float fio2;
		

}
