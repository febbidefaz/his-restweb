package com.dev.generik.entities.RJ;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "WSSTATUSTRANSAKSIRJ")
public class StatusTransaksiRJ {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Statustransaksirj")
	private String statustransaksirj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatustransaksirj() {
		return statustransaksirj;
	}

	public void setStatustransaksirj(String statustransaksirj) {
		this.statustransaksirj = statustransaksirj;
	}

}
