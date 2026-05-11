package com.dev.generik.entities.RJ;

import java.util.Date;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.OptBoolean;

/*import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape; */


@Entity
@Table(name = "WSTIMEIRJ")

public class TaskIDIRJ implements Serializable{
	
	private static final long serialVersionUID = 1989394845641987125L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long dokterid;
	private String dokter ;
	private Long sublayananid ;
	private String Sublayanan ;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	private Date date;
	private Long T12;
	private Long T23;
	private Long T34;
	private Long T45;
	private Long T56;
	private Long T67;
	private Long T17;
	public TaskIDIRJ() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public TaskIDIRJ(Long id, Long dokterid, String dokter, Long sublayananid, String sublayanan, Date date,
			Long t12, Long t23, Long t34, Long t45, Long t56, Long t67, Long t17) {
		super();
		this.id = id;
		this.dokterid = dokterid;
		this.dokter = dokter;
		this.sublayananid = sublayananid;
		this.Sublayanan = sublayanan;
		this.date = date;
		this.T12 = t12;
		this.T23 = t23;
		this.T34 = t34;
		this.T45 = t45;
		this.T56 = t56;
		this.T67 = t67;
		this.T17 = t17;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDokterid() {
		return dokterid;
	}
	public void setDokterid(Long dokterid) {
		this.dokterid = dokterid;
	}
	public String getDokter() {
		return dokter;
	}
	public void setDokter(String dokter) {
		this.dokter = dokter;
	}
	public Long getSublayananid() {
		return sublayananid;
	}
	public void setSublayananid(Long sublayananid) {
		this.sublayananid = sublayananid;
	}
	public String getSublayanan() {
		return Sublayanan;
	}
	public void setSublayanan(String sublayanan) {
		Sublayanan = sublayanan;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getT12() {
		return T12;
	}
	public void setT12(Long t12) {
		T12 = t12;
	}
	public Long getT23() {
		return T23;
	}
	public void setT23(Long t23) {
		T23 = t23;
	}
	public Long getT34() {
		return T34;
	}
	public void setT34(Long t34) {
		T34 = t34;
	}
	public Long getT45() {
		return T45;
	}
	public void setT45(Long t45) {
		T45 = t45;
	}
	public Long getT56() {
		return T56;
	}
	public void setT56(Long t56) {
		T56 = t56;
	}
	public Long getT67() {
		return T67;
	}
	public void setT67(Long t67) {
		T67 = t67;
	}
	public Long getT17() {
		return T17;
	}
	public void setT17(Long t17) {
		T17 = t17;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
