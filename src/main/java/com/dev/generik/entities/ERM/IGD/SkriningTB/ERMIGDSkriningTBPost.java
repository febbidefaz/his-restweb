package com.dev.generik.entities.ERM.IGD.SkriningTB;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SKRININGTBRI")
@Getter
@Setter

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateSkriningTB", procedureName = "UpdateSkriningTB_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Tanggal", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "idDokter", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "batuk", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "rontgen", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "kontak", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "ket", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "ri", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "dm", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "hiv", type = Boolean.class), 			
			}) })

public class ERMIGDSkriningTBPost {
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL")
	private Date tanggal;
	
	@Column(name = "IDDOKTER")
	private Long idDokter;
	
	@Column(name = "BATUK")
	private Boolean batuk;
	
	@Column(name = "RONTGEN")
	private Boolean rontgen;
	
	@Column(name = "KONTAK")
	private Boolean kontak; 
	
	@Column(name = "KET")
	private Long ket;
	
	@Column(name = "RI")
	private Long ri;
	
	@Column(name = "DM")
	private Boolean dm;
	
	@Column(name = "HIV")
	private Boolean hiv;
	

}
