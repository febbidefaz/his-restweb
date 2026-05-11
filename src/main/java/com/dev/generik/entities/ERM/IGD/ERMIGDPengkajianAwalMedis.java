package com.dev.generik.entities.ERM.IGD;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSERMIGDPENGKAJIANAWALMEDIS")
@Getter
@Setter
public class ERMIGDPengkajianAwalMedis {
	@Id
	
	private Long id;
	private Long docid;
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	@Temporal(TemporalType.TIME)
	private Date jamdatang;
	@Temporal(TemporalType.TIME)
	private Date jam;
	private Long anamnese;
	private String keluhan;
	private String  rikessekarang;
	private Long rikespernahdirawat;
	private Date rikespernahdirawatkapan;
	private String rikespernahdirawatdmn;
	private String rikesdiagnosa;
	private Boolean rikesdiagnosaalatimplant;
	private String rikesdiagnosaalatimplanttext;
	private String rikesriwayatobatdiminum;
	private String rikesriwayatobatdibawa; 
	private Long rikesriwayatpenyakitpx; 
	private Date rikesriwayatpenyakitpxkapan; 
	private Long rikesriwayatpenyakitkel; 
	private String rikesriwayatpenyakitkeltext; 
	private Long rikesriwayatpenyakitobat; 
	private String rikesriwayatpenyakitobattext; 
	private Long rikesriwayatpenyakitrepwan; 
	private Long rikesriwayatpenyakitrepwanumur; 
	private String rikesriwayatpenyakitrepwang; 
	private String rikesriwayatpenyakitrepwanp; 
	private String rikesriwayatpenyakitrepwana; 
	private Boolean rialtdakadaalergi; 
	private Boolean rialalergiobat; 
	private String rialalergiobatsebutkan; 
	private String rialalergiobatreaksi; 
	private Boolean rialalergimakanan; 
	private String rialalergimakanansebutkan; 
	private String rialalergimakananreaksi; 
	private Boolean rialalergilainnya; 
	private String rialalergilainnyasebutkan; 
	private String rialalergilainnyareaksi; 
	private Boolean rialfarmasi; 
	private Long rialfarmasiya; 
	private Date rialfarmasiyajam; 
	private Boolean rialgelangalergi; 
	private Long rialgelangalergiya; 
	private Boolean rialtidakdiketahui; 
	private String pemeriksaanfisik; 
		

}
