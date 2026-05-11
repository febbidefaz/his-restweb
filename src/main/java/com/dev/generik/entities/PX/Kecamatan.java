package com.dev.generik.entities.PX;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WSCAMAT")
public class Kecamatan {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private Long Id;

	@Column(name = "Kecamatan")
	private String kecamatan;

	@Column(name = "Prov")
	private Long prov;

	public Long getId() {
		return Id;
	}

	public String getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}

	public Long getProv() {
		return prov;
	}

	public void setProvId(Long prov) {
		this.prov = prov;
	}

}
