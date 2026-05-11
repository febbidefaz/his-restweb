package com.dev.generik.entities.ERM.IGD.SkriningHPPVK;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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
@Table(name = "RISIKOHPPADMISINPERSALINAN")
@Getter
@Setter
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateERMRisikoHPPAdmisiNPersalinan", procedureName = "UpdateERMRisikoHPPAdmisiNPersalinan_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "tanggal", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "kel", type = Date.class), 
			}) })
public class ERMIGDVKHPP {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "ID")
	private Long id;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL")
	private Date tanggal;
	private Long kel;
	
	public ERMIGDVKHPP() {}
	
	public ERMIGDVKHPP (Long id, Date tanggal, Long kel) {
		this.id = id;
		this.tanggal = tanggal;
		this.kel = kel;
	}

}
