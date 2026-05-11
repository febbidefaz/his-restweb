package com.dev.generik.entities.RJ.SkriningTB;

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
@Table(name = "SKRININGTB")
@Getter
@Setter

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateSkriningTBRJ", procedureName = "UpdateSkriningTBRJ_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Tanggal", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "idDokter", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "batuk", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "sesak", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "beratbadan", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "riwayat", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "ket", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "dm", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "hiv", type = Boolean.class), 			
			}) })

public class ERMRJSkriningTBPost {
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
	
	@Column(name = "SESAK")
	private Boolean sesak;
	
	@Column(name = "BERATBADAN")
	private Boolean beratBadan; 
	
	@Column(name = "RIWAYAT")
	private Boolean riwayat; 
	
	@Column(name = "KET")
	private Long ket;	
	
	@Column(name = "DM")
	private Boolean dm;
	
	@Column(name = "HIV")
	private Boolean hiv;
	

}
