package com.dev.generik.entities.HaloRSA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NOWAANDROID")
public class NoWaAndroid {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NOWA")
	private String nowa;

	@Column(name = "KET")
	private String ket;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNowa() {
		return nowa;
	}

	public void setNowa(String nowa) {
		this.nowa = nowa;
	}

	public String getKet() {
		return ket;
	}

	public void setKet(String ket) {
		this.ket = ket;
	}

}
