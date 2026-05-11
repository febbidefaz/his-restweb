package com.dev.generik.entities.TB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "TB_ICD")

public class TBICD {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Nullable
	@Column(name = "ICD")
	private String icd;

	@Column(name = "PENYAKIT")
	@Nullable
	private String penyakit;

	public TBICD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TBICD(String icd, String penyakit) {
		super();
		this.icd = icd;
		this.penyakit = penyakit;
	}

	public String getIcd() {
		return icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

	public String getPenyakit() {
		return penyakit;
	}

	public void setPenyakit(String penyakit) {
		this.penyakit = penyakit;
	}

	
	
}
