package com.dev.generik.entities.RJ.Operasi;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "WSLABHASILBATAS1")
@Getter
@Setter
public class OperasiGetPrice {
	@Id	
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDREG")
	private Long idReg;
	
	@JsonIgnore
	@Column(name = "OPE_ID")
	private Long opeID;
	
	@Column(name = "OPERATOR_OUT")
	private Double operatorOut;
	
	@Column(name = "ANESTESI_OUT")
	private Double anestesiOut;
	
	@Column(name = "ASS_OUT")
	private Double assOut;
	
	@Column(name = "ALAT_OUT")
	private Double alatOut;
	
	@Column(name = "BAHAN_OUT")
	private Double bahanOut;
	
	@Column(name = "OK_RR_OUT")
	private Double okRROut;
	
	@Column(name = "ASSANES_OUT")
	private Double assAnesOut;
	
	@Column(name = "JASA_OUT")
	private Double jasaOut;
	
	@Column(name = "CSSD_OUT")
	private Double cssdOut;
}
