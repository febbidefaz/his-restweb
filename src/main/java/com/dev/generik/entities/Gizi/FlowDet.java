package com.dev.generik.entities.Gizi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LOGGIZIFLOWWSDET")
@IdClass(FlowDetClass.class)
@Getter
@Setter

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateLogGiziFlowDet", procedureName = "UpdateLogGiziFlowDet_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "productID", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "qty", type = Long.class), 
		//	@StoredProcedureParameter(mode = ParameterMode.IN, name = "diterima", type = String.class), 
		//	@StoredProcedureParameter(mode = ParameterMode.IN, name = "ket", type = String.class), 
			}) })

public class FlowDet {
	@Id	
	@Column(name = "ID")
	private Long id;
	
	@Id	
	@Column(name = "PRODUCTID")
	private String productID;
	
	@Column(name = "Qty")
	private Long qty;
	
//	@Column(name = "Diterima")
//	private String diterima;
	
//	@Column(name = "Ket")
//	private String ket;
	
	public FlowDet() {}
	
	public FlowDet(Long id, String productID, Long qty
		//	, String diterima, String ket
			) {
		this.id = id;
		this.productID = productID;
		this.qty = qty;	
	//	this.diterima = diterima;
	//	this.ket =  ket;
	}
	
	 // Relasi ManyToOne dengan Flow
  //  @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id")
    //private Flow flow;
	
}
