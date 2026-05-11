package com.dev.generik.entities.PX;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "WSPXID")
public class PxId {
	/*
	 * SELECT i.ID AS pxid , dbo.TMasuk_fn(t.ID) AS tmsk , p.RegNum AS norm ,
	 * kd.RoomName AS room , k.Kelas AS kelas , p.Nama AS px , p.Addr AS addr ,
	 * dbo.JMasuk_fn(t.ID) AS jmsk , t.ID AS regid , dbo.Paviliun.ID AS pavid ,
	 * dbo.Paviliun.Pav AS pav FROM dbo.PasInap AS i INNER JOIN dbo.Therapy AS t ON
	 * i.ID = t.ID INNER JOIN dbo.PasienList AS p ON t.Register = p.RegNum INNER
	 * JOIN dbo.[Kelas details] AS kd ON i.KelasID = kd.ID AND i.RoomID = kd.RoomID
	 * INNER JOIN dbo.Kelas AS k ON kd.ID = k.ID INNER JOIN dbo.Paviliun ON kd.PavID
	 * = dbo.Paviliun.ID WHERE (i.TKeluar IS NULL)
	 */
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Nama")
	private String nama;

	@Column(name = "Norm")
	private String norm;

	@Column(name = "Addr")
	private String addr;

	@Temporal(TemporalType.DATE)
	private Date tgl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNorm() {
		return norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

}
