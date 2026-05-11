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
@Table(name = "WSRESPONTIMEPXPULANG")

public class TracerPXPlg implements Serializable{
	
	private static final long serialVersionUID = 1989394845641987125L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	private String pxrs ;
	private String room ;
	private Long pavid ;
	private Long T12;
	private Long T23;
	private Long T34;
	private Long T45;
	private Long T56;
	private Long T67;
	private Long T78;
	private Long T89;
	private Long T19;
	
	public TracerPXPlg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TracerPXPlg(Long id, Date tanggal, String pxrs, String room, Long pavid, Long t12, Long t23, Long t34,
			Long t45, Long t56, Long t67, Long t78, Long t89, Long t19) {
		super();
		this.id = id;
		this.tanggal = tanggal;
		this.pxrs = pxrs;
		this.room = room;
		this.pavid = pavid;
		T12 = t12;
		T23 = t23;
		T34 = t34;
		T45 = t45;
		T56 = t56;
		T67 = t67;
		T78 = t78;
		T89 = t89;
		T19 = t19;
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

	public Long getT78() {
		return T78;
	}

	public void setT78(Long t78) {
		T78 = t78;
	}

	public Long getT89() {
		return T89;
	}

	public void setT89(Long t89) {
		T89 = t89;
	}

	public Long getT19() {
		return T19;
	}

	public void setT19(Long t19) {
		T19 = t19;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
