package com.dev.generik.entities.ERM.Resep;

//import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
//import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "OBATRSPWS")
@IdClass(ObAtRspClass.class)
@Getter
@Setter

/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateLogGiziFlowDet", procedureName = "UpdateLogGiziFlowDet_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "productID", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "qty", type = Long.class), 
			}) })*/

public class ObAtRspRes {
	@Id	
	@Column(name = "ID")
	private Long id;
	
	@Id	
	@Column(name = "KODE")
	private String kode;
	
	@Column(name = "QTY")
	private Long qty;
	
	@Column(name = "SIGNA")
	private Long signa;
	
	//private List<ContensTab> racikanList;
	
	public ObAtRspRes() {}
	
	public ObAtRspRes(Long id, String kode, Long qty, Long signa) {
		this.id = id;
		this.kode = kode;
		this.qty = qty;		
		this.signa = signa;
	}
	
	 // Relasi ManyToOne dengan Flow
  //  @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id")
    //private Flow flow;
	
}
