package com.dev.generik.entities.Dokter;

import java.util.Date;

import jakarta.persistence.Entity;
//import javax.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "WSVISITEDOKTERONSITE")
public class VisiteDokterOnsite {

	@Id
	private String keyId;
	private Long pxId;
	private String noRm;
	private String namaPx;
	private Long dokterId;
	private String nadok;
	private Long klasId;
	private Long roomId;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7", lenient = OptBoolean.FALSE)
	@Temporal(TemporalType.DATE)
	private Date tglVisit;

	public VisiteDokterOnsite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPxId() {
		return pxId;
	}

	public void setPxId(Long pxId) {
		this.pxId = pxId;
	}

	public String getNoRm() {
		return noRm;
	}

	public void setNoRm(String noRm) {
		this.noRm = noRm;
	}

	public String getNamaPx() {
		return namaPx;
	}

	public void setNamaPx(String namaPx) {
		this.namaPx = namaPx;
	}

	public Long getDokterId() {
		return dokterId;
	}

	public void setDokterId(Long dokterId) {
		this.dokterId = dokterId;
	}

	public String getNadok() {
		return nadok;
	}

	public void setNadok(String nadok) {
		this.nadok = nadok;
	}

	public Long getKlasId() {
		return klasId;
	}

	public void setKlasId(Long klasId) {
		this.klasId = klasId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Date getTglVisit() {
		return tglVisit;
	}

	public void setTglVisit(Date tglVisit) {
		this.tglVisit = tglVisit;
	}

}
