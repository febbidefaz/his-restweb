package com.dev.generik.entities.ERM.PA;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "PAPLANWS")

@Getter
@Setter
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateSPPA", procedureName = "UpdateSPPA_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NO", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDDokter", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TGL", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Jam", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "KelasID", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "RoomID", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LokasiOrgan", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "DiagnosaKlinik", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Fiksatif", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Biopsi", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Sputurn", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "JamOp", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "JamSampel", type = Date.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "KetKlinik", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "RiwayatLab", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NoHP", type = String.class),
		//		@StoredProcedureParameter(mode = ParameterMode.IN, name = "KetCancel", type = Long.class),
				}) })

public class SPPA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NO")
	private Long no;

	@Column(name = "ID")
	private Long id;
	
	@Column(name = "IDDOKTER")
	private Long idDokter;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGL")
	private Date tgl; 
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.TIME)
	@Column(name = "JAM")
	private Date jam;
	
	@Column(name = "KelasID")
	private Long kelasID;
	
	@Column(name = "RoomID")
	private Long roomID;	
	
	@Column(name = "LOKASIORGAN")
	private String lokasiOrgan;
	
	@Column(name = "DIAGNOSAKLINIK")
	private String diagnosaKlinik;
	
	@Column(name = "Fiksatif")
	private String fiksatif;
	
	@Column(name = "Biopsi")
	private String biopsi;
	
	@Column(name = "Sputurn")
	private String sputurn;
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.TIME)
	@Column(name = "JAMOP")
	private Date jamOp;
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.TIME)
	@Column(name = "JAMSAMPEL")
	private Date jamSampel;
	
	@Column(name = "KETKLINIK")
	private String ketKlinik;
	
	@Column(name = "RIWAYATLAB")
	private String riwayatLab;
	
	@Column(name = "NOHP")
	private String noHP;
	
	@Column(name = "Proses")
	private Boolean proses;
	
	@Column(name = "KETCANCEL")
	private Long ketCancel;	
	
}

