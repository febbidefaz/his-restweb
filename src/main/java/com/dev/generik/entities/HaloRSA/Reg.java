package com.dev.generik.entities.HaloRSA;

//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "WSREG")
public class Reg {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Reg")
	private String reg;

	@Column(name = "Status")
	private Long status;

	@Column(name = "Icon")
	private String icon;

	@Column(name = "Biaya")
	private String biaya;

	@Column(name = "Norek")
	private String norek;

	@Column(name = "Menu")
	private String menu;

	@Column(name = "Aktif")
	private Long aktif;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getBiaya() {
		return biaya;
	}

	public void setBiaya(String biaya) {
		this.biaya = biaya;
	}

	public String getNorek() {
		return norek;
	}

	public void setNorek(String norek) {
		this.norek = norek;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public Long getAktif() {
		return aktif;
	}

	public void setAktif(Long aktif) {
		this.aktif = aktif;
	}
}
