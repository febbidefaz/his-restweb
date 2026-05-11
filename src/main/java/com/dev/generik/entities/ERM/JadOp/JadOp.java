package com.dev.generik.entities.ERM.JadOp;

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
@Table(name = "JADWALOP")

@Getter
@Setter
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateJadwalOp", procedureName = "UpdateJadwalOp_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "nomor", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tindakanId", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "kelasId", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "roomId", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "dokterId", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tanggal", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "jam", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "status", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "diagnosaId", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ketDiag", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tempat", type = Long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "klsStrgRen", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "kelasIdRen", type = Long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "roomIdRen", type = Long.class), 
				}) }) 

public class JadOp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOMOR")
	private Long nomor;

	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TINDAKANID")
	private String tindakanId;
	
	@Column(name = "KELASID")
	private Long kelasId;
	
	@Column(name = "ROOMID")
	private Long roomId;
	
	@Column(name = "DOKTERID")
	private String dokterId;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL")
	private Date tanggal; 
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.TIME)
	@Column(name = "JAM")
	private Date jam;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "DIAGNOSAID")
	private String diagnosaId;
	
	@Column(name = "KETDIAG")
	private String ketDiag;
	
	@Column(name = "TEMPAT")
	private Long tempat;
	
	@Column(name = "KLSSTRGREN")
	private Long klsStrgRen;
	
	@Column(name = "KelasIDREN")
	private Long kelasIdRen;
	
	@Column(name = "ROOMIDREN")
	private Long roomIdRen;
	
		
}

