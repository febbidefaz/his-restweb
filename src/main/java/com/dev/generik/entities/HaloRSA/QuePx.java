package com.dev.generik.entities.HaloRSA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
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

	

}
