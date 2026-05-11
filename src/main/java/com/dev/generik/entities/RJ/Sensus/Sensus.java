package com.dev.generik.entities.RJ.Sensus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "THERAPY")
@Getter
@Setter

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateSensusIRJ", procedureName = "UpdateSensusIRJ_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "datang", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "lama", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "upx", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "sensusirj", type = Long.class),
			}) })

public class Sensus {
	@Id
	@Column(name = "ID")
	private Long id;
			
	@Column(name = "DATANG")
	private Boolean datang;
	
	@Column(name = "LAMA")
	private Boolean lama;
	
	@Column(name = "UPX")
	private Long upx;	
	
	@Column(name = "SENSUSIRJ")
	private Long sensusIRJ;
	
	@Column(name = "NOSEP")
	private String noSEP;
	
}
