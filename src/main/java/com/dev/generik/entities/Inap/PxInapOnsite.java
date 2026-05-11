package com.dev.generik.entities.Inap;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "WSPXINAPONSITE")
@Getter
@Setter
public class PxInapOnsite {

	@Id
	private Long pxId;
	private String noRm;
	private String namaPx;
	private Long klasId;
	@Column(name = "KELAS")
	private String kelas;
	private Long roomId;
	@Column(name = "ROOMNAME")
	private String roomName;
	private Long pavId;
	@Column(name = "PAV")
	private String pav;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date tglMsk;

	@Column(name = "KD")
	private String kd;
	public Date getTglMsk() {
		return tglMsk;
	}
	
	@Column(name = "NOMER")
	private Long no;	
	private Long cek;
	
}
