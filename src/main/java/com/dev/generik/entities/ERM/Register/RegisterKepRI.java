package com.dev.generik.entities.ERM.Register;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "KEPRIREGISTER")
@Getter
@Setter
/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateLogGiziFlow", procedureName = "UpdateLogGiziFlow_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "flowTgl", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "jam", type = Date.class), 
			}) })*/
public class RegisterKepRI {
	@Id
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOMER")
	private Long no;	
	
	@Column(name = "ID")
	private Long id;

	@Column(name = "PENERIMA")
	private String penerima;
	
	@Column(name = "PENTELP")
	private String telp;
	
	public RegisterKepRI() {}
	
	public RegisterKepRI (Long no, Long id, String penerima, String telp) {
		this.no = no;
		this.id = id;		
		this.penerima = penerima;
		this.telp = telp;
	}
	
	  // Relasi OneToMany dengan Book
 //   @OneToMany(mappedBy = "flow", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  private List<FlowDet> flowDet;
	

}
