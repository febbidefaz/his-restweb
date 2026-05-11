package com.dev.generik.entities.ERM.Rad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
// import javax.persistence.Lob;
import jakarta.persistence.Table;

//import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "RADIOLOGI")

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateRadiologi", procedureName = "UpdateRadiologi_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "normlv", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "kesimpulan", type = String.class) }) })

public class Radiologi {

	@Id
	// @GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Periksa")
	private String periksa;
	
	@Column(name = "NORMLV")
	@Nullable
	private String normlv;

	@Column(name = "Kesimpulan")
	@Nullable
	private String kesimpulan;

	public Radiologi() {
		super();
	}

	public Radiologi(Long id, String periksa, String normlv, String kesimpulan) {
		super();
		this.id = id;
		this.periksa = periksa;
		this.normlv = normlv;
		this.kesimpulan = kesimpulan;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getPeriksa() {
		return periksa;
	}

	public void setPeriksa(String periksa) {
		this.periksa = periksa;
	}

	public String getNormlv() {
		return normlv;
	}

	public void setNormlv(String normlv) {
		this.normlv = normlv;
	}

	public String getKesimpulan() {
		return kesimpulan;
	}

	public void setKesimpulan(String kesimpulan) {
		this.kesimpulan = kesimpulan;
	}

}
