package com.dev.generik.entities.ERM.Resep;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSCEKRESEPOL")
@Getter
@Setter
/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateLogGiziFlow", procedureName = "UpdateLogGiziFlow_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "flowTgl", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "jam", type = Date.class), 
			}) }) */
public class CekResepOL {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "IDV")
	private Long idv;
	
	public CekResepOL() {}
	
	public CekResepOL (Long id, Long idv) {
		this.id = id;
		this.idv = idv;
		
	}
	
	  // Relasi OneToMany dengan Book
 //   @OneToMany(mappedBy = "flow", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  private List<FlowDet> flowDet;
	

}
