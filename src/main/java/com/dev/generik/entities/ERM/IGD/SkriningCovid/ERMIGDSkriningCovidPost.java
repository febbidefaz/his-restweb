package com.dev.generik.entities.ERM.IGD.SkriningCovid;

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
@Table(name = "SKRININGCOVID")
@Getter
@Setter

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateSkriningCovid", procedureName = "UpdateSkriningCovid_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Tanggal", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "TandaNGejala", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Riwayat", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Demam", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Usia", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Kel", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Suhu", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Gejala", type = Boolean.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Ratio", type = Boolean.class), 			
			}) })

public class ERMIGDSkriningCovidPost {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Temporal(TemporalType.DATE)	
	private Date tanggal;
	
	@Column(name = "IDDOKTER")
	private Long idDokter;
	
	@Column(name = "TANDANGEJALA")
	private Boolean tandaNGejala;
	
	@Column(name = "Riwayat")
	private Boolean riwayat;
	
	@Column(name = "Demam")
	private Boolean demam;
	
	@Column(name = "Usia")
	private Boolean usia;
	
	@Column(name = "Kel")
	private Boolean kel;
	
	@Column(name = "Suhu")
	private Boolean suhu;
	
	@Column(name = "Gejala")
	private Boolean gejala;
	
	@Column(name = "Ratio")
	private Boolean ratio;
}
