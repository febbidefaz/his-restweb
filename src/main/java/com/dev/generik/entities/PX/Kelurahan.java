package com.dev.generik.entities.PX;

import jakarta.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lurah")
public class Kelurahan {
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String lurah;

	private String camat;

	private Long camatid;

	public Long getId() {
		return id;
	}

	public String getLurah() {
		return lurah;
	}

	public void setLurah(String lurah) {
		this.lurah = lurah;
	}

	public String getCamat() {
		return camat;
	}

	public void setCamat(String camat) {
		this.camat = camat;
	}

	public Long getCamatid() {
		return camatid;
	}

	public void setCamatid(Long camatid) {
		this.camatid = camatid;
	}

}
