package com.dev.generik.entities.ERM.Register;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "KEPRIREGISTER")
@IdClass(RegisterKepRIGetClass.class)
@Getter
@Setter
/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateLogGiziFlow", procedureName = "UpdateLogGiziFlow_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "flowTgl", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "jam", type = Date.class), 
			}) })*/
public class RegisterKepRIGet {
	@Id
	@Column(name = "ID")
	private Long id;
		
	@Id	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOMER")
	private Long no;	

	@Column(name = "PENERIMA")
	private String penerima;
	
	@Column(name = "PENTELP")
	private String telp;
	
	public RegisterKepRIGet() {}
	
	public RegisterKepRIGet (Long id, Long no, String penerima, String telp) {
		this.id = id;
		this.no = no;
		this.penerima = penerima;
		this.telp = telp;
	}
	
	  // Relasi OneToMany dengan Book
 //   @OneToMany(mappedBy = "flow", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  private List<FlowDet> flowDet;
	

}
