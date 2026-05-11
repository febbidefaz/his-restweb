package com.dev.generik.entities.Inap;

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
@Table(name = "WSRESPONTIMEPXRI")

public class TracerPXRI implements Serializable{
	
	private static final long serialVersionUID = 1989394845641987126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	private String pxrs ;
	private String room ;
	private Long pavid ;
	private Long igd;
	private Long ok;
	
	public TracerPXRI() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TracerPXRI(Long id, Date tanggal, String pxrs, String room, Long pavid, Long igd, Long ok) {
		super();
		this.id = id;
		this.tanggal = tanggal;
		this.pxrs = pxrs;
		this.room = room;
		this.pavid = pavid;
		this.igd = igd;
		this.ok = ok;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTanggal() {
		return tanggal;
	}
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	public String getPxrs() {
		return pxrs;
	}
	public void setPxrs(String pxrs) {
		this.pxrs = pxrs;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Long getPavid() {
		return pavid;
	}
	public void setPavid(Long pavid) {
		this.pavid = pavid;
	}
	public Long getIgd() {
		return igd;
	}
	public void setIgd(Long igd) {
		this.igd = igd;
	}
	public Long getOk() {
		return ok;
	}
	public void setOk(Long ok) {
		this.ok = ok;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	

}
