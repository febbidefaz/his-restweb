package com.dev.generik.entities.PX;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import org.springframework.lang.Nullable;
import jakarta.persistence.Table;

@Entity
@Table(name = "WSASURANSI")
public class Asuransi {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "PxRS")
	private String pxrs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPxrs() {
		return pxrs;
	}

	public void setPxrs(String pxrs) {
		this.pxrs = pxrs;
	}

}
