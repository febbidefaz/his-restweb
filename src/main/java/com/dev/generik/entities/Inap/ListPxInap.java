package com.dev.generik.entities.Inap;

import java.util.Date;
//import java.util.List;

//import javax.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSPXINAP")
@Getter
@Setter
//@SecondaryTable(name = "WSVISITDOKTER", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class ListPxInap {
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
	@Column(name = "PXID")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "TMSK")
	private Date tmsk;

	@Column(name = "NORM", length = 10)
	private String norm;

	@Column(name = "ROOM")
	private String room;

	@Column(name = "KELAS")
	private String kelas;

	@Column(name = "PX")
	private String px;

	@Column(name = "ADDR")
	private String addr;

	@Temporal(TemporalType.TIME)
	@Column(name = "JMSK")
	private Date jmsk;

	@Column(name = "REGID")
	private Long regid;

	@Column(name = "PAVID")
	private Long pavid;

	@Column(name = "PAV")
	private String pav;

	@Column(name = "BIAYA")
	private Long biaya;

	@Column(name = "PHK3")
	private Long phk3;

	@Column(name = "KELASBPJS")
	private String kelasbpjs;

	@Column(name = "PXRS")
	private String pxrs;

//	@OneToMany(cascade = CascadeType.ALL)
//	List<VisitDokter> VisitDokters;
	/*
	 * @Column(name="Dokter", table ="WSVISITDOKTER") private String dokter;
	 * 
	 * @Column(name="Dokterid", table ="WSVISITDOKTER") private Long dokterid;
	 * 
	 */ /*
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTmsk() {
		return tmsk;
	}

	public void setTmsk(Date tmsk) {
		this.tmsk = tmsk;
	}

	public String getNorm() {
		return norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public String getPx() {
		return px;
	}

	public void setPx(String px) {
		this.px = px;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getJmsk() {
		return jmsk;
	}

	public void setJmsk(Date jmsk) {
		this.jmsk = jmsk;
	}

	public Long getRegid() {
		return regid;
	}

	public void setRegid(Long regid) {
		this.regid = regid;
	}

	public Long getPavid() {
		return pavid;
	}

	public void setPavid(Long pavid) {
		this.pavid = pavid;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public Long getBiaya() {
		return biaya;
	}

	public void setBiaya(Long biaya) {
		this.biaya = biaya;
	}

	public Long getPhk3() {
		return phk3;
	}

	public void setPhk3(Long phk3) {
		this.phk3 = phk3;
	}

	public String getKelasbpjs() {
		return kelasbpjs;
	}

	public void setKelasbpjs(String kelasbpjs) {
		this.kelasbpjs = kelasbpjs;
	}

	public String getPxrs() {
		return pxrs;
	}

	public void setPxrs(String pxrs) {
		this.pxrs = pxrs;
	} */

	/*
	 * 
	 * public String getDokter() { return dokter; } public void setDokter(String
	 * dokter) { this.dokter = dokter; } public Long getDokterid() { return
	 * dokterid; } public void setDokterid(Long dokterid) { this.dokterid =
	 * dokterid; }
	 */
}
