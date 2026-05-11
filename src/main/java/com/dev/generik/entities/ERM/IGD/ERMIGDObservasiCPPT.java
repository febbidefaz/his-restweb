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
@Table(name = "WSERMIGDOBSERVASICPPT")
@Getter
@Setter
public class ERMIGDObservasiCPPT {
	@Id
	private Long id;
	private Long no;
	@Temporal(TemporalType.DATE)
//	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	private Date tgl; 
	@Temporal(TemporalType.TIME)
	private Date jam; 
	
	private String ppaintruksi; 
	private String ppa; 
	private String drjaga; 
	
		

}
