package com.dev.generik.entities.Lab;


import org.springframework.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name = "HASILPCR")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateHasilPCR", procedureName = "UpdateHasilPCR_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "pcr", type = Integer.class), }) })

public class HasilPCR {
	@Id
//	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Pcr")
	@Nullable
	private String pcr;

	public HasilPCR() {
		super();
	}

	public HasilPCR(Long id, String pcr) {
		super();
		this.id = id;

		this.pcr = pcr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPcr() {
		return pcr;
	}

	public void setPcr(String pcr) {
		this.pcr = pcr;
	}

}
