package com.dev.generik.entities.ERM.Resep;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CONTENSTABWS")
@IdClass(ContensTabClass.class)
@Getter
@Setter

/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateLogGiziFlowDet", procedureName = "UpdateLogGiziFlowDet_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "productID", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "qty", type = Long.class), 
			}) })*/

public class ContensTab implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name = "ID")
	private Long id;
	
	@Id	
	@Column(name = "MFDTD")
	private String mfdtd;
	
	@Id	
	@Column(name = "KODE")
	private String kode;
	
	@Column(name = "QTY")
	private Float qty;
	
	@Column(name = "RASIO")
	private Float rasio;
	
	public ContensTab() {}
	
	public ContensTab(Long id, String mfdtd, String kode, Float qty, Float rasio) {
		this.id = id;
		this.mfdtd = mfdtd;
		this.kode = kode;
		this.qty = qty;		
		this.rasio = rasio;
	}
	
	 // Relasi ManyToOne dengan Flow
  //  @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id")
    //private Flow flow;
	
}
