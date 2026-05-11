package com.dev.generik.entities.Dokter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//import javax.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "WSVISITDOKTER")
public class VisitDokter {
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private String id;
	
	@Column(name = "Idpx")
	private Long idpx;

	@Column(name = "Dokter")
	private String dokter;

	@Column(name = "Dokterid")
	private Long dokterid;

//	@OneToMany(mappedBy = "id")
//	ListPxInap listPxInap;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Long getIdpx() {
		return idpx;
	}

	public void setIdpx(Long idpx) {
		this.idpx = idpx;
	}

	public String getDokter() {
		return dokter;
	}

	public void setDokter(String dokter) {
		this.dokter = dokter;
	}

	public Long getDokterid() {
		return dokterid;
	}

	public void setDokterid(Long dokterid) {
		this.dokterid = dokterid;
	}

}
