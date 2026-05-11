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
@Table(name = "ETEMPLATE")
@Getter
@Setter
/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateLogGiziFlow", procedureName = "UpdateLogGiziFlow_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "flowTgl", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "jam", type = Date.class), 
			}) }) */
public class ResepOLTemplate {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEMPLATE_ID")
	private Long id;
		
	@Column(name = "BY_DOKTER")
	private Long idDokter;
	
	@Column(name = "TEMPLATE_NAME")
	private String nama;
	
	@Column(name = "APPROVED")
	private Boolean approved;
	
	@Column(name = "RACIKAN")
	private Boolean racikan;
	
	public ResepOLTemplate() {}
	
	public ResepOLTemplate (Long id, Long idDokter, String nama, Boolean approved, Boolean racikan) {
		this.id = id;
		this.idDokter = idDokter;
		this.nama = nama;
		this.approved = approved;
		this.racikan = racikan;
	}
	
	  // Relasi OneToMany dengan Book
 //   @OneToMany(mappedBy = "flow", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  private List<FlowDet> flowDet;
	

}
