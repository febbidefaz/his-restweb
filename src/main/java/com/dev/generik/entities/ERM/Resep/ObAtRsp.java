package com.dev.generik.entities.ERM.Resep;

import java.util.Collections;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OBATRSPWS")
@IdClass(ObAtRspClass.class)
@Getter
@Setter

/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateLogGiziFlowDet", procedureName = "UpdateLogGiziFlowDet_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "productID", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "qty", type = Long.class), 
			}) })*/
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_EMPTY)  // Serialisasi properti jika tidak null atau kosong
public class ObAtRsp {
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
	
	@Column(name = "KET")
	private String ket;
	
	@Transient
	private List<ContensTab> racikanList;
	
	public List<ContensTab> getRacikanList() {
	    return racikanList == null ? Collections.emptyList() : racikanList;
	}

	public void setRacikanList(List<ContensTab> racikanList) {
	    this.racikanList = racikanList;
	}
	
	public ObAtRsp() {}
	
	public ObAtRsp(Long id, String kode, Long qty, Long signa, String ket) {
		this.id = id;
		this.kode = kode;
		this.qty = qty;		
		this.signa = signa;
		this.ket = ket;
	}	
}
