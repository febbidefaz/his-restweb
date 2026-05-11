package com.dev.generik.entities.HaloRSA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WSQUEPX")
public class QuePx {
	/*
	 * SELECT Doctor, jam_praktek, dbo.AllPxByDokter_fn(Doctor, jam_praktek) AS
	 * allpx, dbo.HandlePxByDokter_fn(Doctor, jam_praktek) AS finishpx,
	 * dbo.QuePx_fn(Doctor, jam_praktek) AS quepx, dbo.cNumberPoliCalled_fn(Doctor)
	 * AS numberpx, dbo.GetSpecialistName_fn(Doctor) AS poli, (SELECT SpecialisID
	 * FROM dbo.Dokter AS d WHERE (ID = qd.Doctor)) AS idpoli, (SELECT Dokter FROM
	 * dbo.Dokter AS d WHERE (ID = qd.Doctor)) AS dokter FROM dbo.wsQueDokter AS qd
	 */
	@Id
	@Column(name = "doctor")
	private String id;

	private Long docid;
	private Long jp;
	private Long allpx;
	private Long finishpx;
	private Long quepx;
	private Long numberpx;
	private String poli;
	private Long idpoli;
	private String dokter;
	private String fotoOL;

	public QuePx() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getDocid() {
		return docid;
	}

	public void setDocid(Long docid) {
		this.docid = docid;
	}

	public Long getJp() {
		return jp;
	}

	public void setJp(Long jp) {
		this.jp = jp;
	}

	public Long getAllpx() {
		return allpx;
	}

	public void setAllpx(Long allpx) {
		this.allpx = allpx;
	}

	public Long getFinishpx() {
		return finishpx;
	}

	public void setFinishpx(Long finishpx) {
		this.finishpx = finishpx;
	}

	public Long getQuepx() {
		return quepx;
	}

	public void setQuepx(Long quepx) {
		this.quepx = quepx;
	}

	public Long getNumberpx() {
		return numberpx;
	}

	public void setNumberpx(Long numberpx) {
		this.numberpx = numberpx;
	}

	public String getPoli() {
		return poli;
	}

	public void setPoli(String poli) {
		this.poli = poli;
	}

	public Long getIdpoli() {
		return idpoli;
	}

	public void setIdpoli(Long idpoli) {
		this.idpoli = idpoli;
	}

	public String getDokter() {
		return dokter;
	}

	public void setDokter(String dokter) {
		this.dokter = dokter;
	}

	public String getFotoOL() {
		return fotoOL;
	}

	public void setFotoOL(String fotoOL) {
		this.fotoOL = fotoOL;
	}

}
