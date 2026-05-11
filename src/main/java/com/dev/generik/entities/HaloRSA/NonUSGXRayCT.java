package com.dev.generik.entities.HaloRSA;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import org.springframework.lang.Nullable;

@Entity
@IdClass(NonUSGXRayCTId.class)
@Table(name = "NONUSGXRAYCT")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateNonUSGXRayCT", 
				procedureName = "UpdateNonUSGXRayCT_sp", 
				parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "idrad", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "jenisid", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "result", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "kesimpulan", type = String.class) }) })

public class NonUSGXRayCT {

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)	
	@Column(name = "Idrad")
	private Long idrad;
	
	@Id
	@Column(name = "Jenisid")
	private Long jenisid;
	              

	@Column(name = "Result")
	@Nullable
	private String result;

	@Column(name = "Kesimpulan")
	@Nullable
	private String kesimpulan;

	public NonUSGXRayCT() {
		super();
	}

	public NonUSGXRayCT(Long idrad, Long jenisid, String result, String kesimpulan) {
		super();
		this.idrad = idrad;
		this.jenisid = jenisid;
		this.result = result;
		this.kesimpulan = kesimpulan;
	}

	public Long getIdrad() {
		return idrad;
	}

	public void setIdrad(Long idrad) {
		this.idrad = idrad;
	}

	public Long getJenisid() {
		return jenisid;
	}

	public void setJenisid(Long jenisid) {
		this.jenisid = jenisid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getKesimpulan() {
		return kesimpulan;
	}

	public void setKesimpulan(String kesimpulan) {
		this.kesimpulan = kesimpulan;
	}

}
