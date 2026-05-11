package com.dev.generik.entities.Dokter;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "WSSPECIALISTB")
public class SpecialistB {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Category")
	private String category;

	@Column(name = "FotoOL")
	private String fotoOL;

	@Column(name = "LayID")
	private Long layID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFotoOL() {
		return fotoOL;
	}

	public void setFotoOL(String fotoOL) {
		this.fotoOL = fotoOL;
	}

	public Long getLayID() {
		return layID;
	}

	public void setLayID(Long layID) {
		this.layID = layID;
	}

}
