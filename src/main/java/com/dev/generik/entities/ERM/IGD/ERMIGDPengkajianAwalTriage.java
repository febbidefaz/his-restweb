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
@Table(name = "WSERMIGDPENGKAJIANAWALTRIAGE")
@Getter
@Setter
public class ERMIGDPengkajianAwalTriage {
	@Id
	
	private Long id;
	private Long docid;
	@Temporal(TemporalType.DATE)	
//	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT+7")
	private Date tanggal;
	@Temporal(TemporalType.TIME)
//	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
	private Date Jamdatang;
	@Temporal(TemporalType.TIME)
	private Date jam;
	private Long kepAnamnese;
	private Long kepKebPel;
	private String kepKeluhan;
	private Long suhu;
	private Long nadi;
	private Long sistole;
	private Long diastole;
	private Long nafas;
	private Long spo2; 
	private Long gda; 
	private Long tinggi;
	private Float berat;
	private Float lila;
	private Float lika;
	private Long priSurJlnnapas;
	private Long priSurPerna;
	private Long priSurSirku;
	private Long priSurDis;
	private String priSurTinawal;
	private Long triage;
	private Long jlnnafassum;
	private Boolean jlnnafassnoring;
	private Boolean jlnnafasgargling;
	private Boolean jlnnafasstridor;
	private Boolean jlnnafasdevisatrakea;
	private Boolean jlnnafasjejasdileher;
	private Boolean jlnnafasmassadi;
	private String jlnnafasmassaditext; 
	private Long prnafasankusmaul;
	private Long prnafasanfrek;
	private Long prnafasanretraksi; 
	private Long prnafasansianosis; 
	private String prnafasanjejasdi;
	private Boolean prnafasanjejasditext;
	private Boolean prnafasanpneumothorax; 
	private Boolean prnafasanhemotoraks; 
	private Boolean Prnafasanronchi; 
	private Boolean prnafasanwheezing; 
	private Boolean prnafasandistressnafasberat;
	private Boolean prnafasanhentinafas;
	private Long sirkulasiakraldingin;
	private Long sirkulasicrt;
	private Long sirkulasipendarahan; 
	private Float sirkulasipendarahanm;
	private Float sirkulasipendarahank; 
	private Boolean sirkulasipendarahanh;
	private Boolean sirkulasihentijantung;
	private Long  disabilitygcs;
	private String disabilitygcsm;
	private String disabilitygcsk;
	private String disabilitygcsh;
	private String disabilitygcsht;
	private Long disabilitypupil; 
	private String disabilitypupilm;
	private String disabilitypupilk;
	private String disabilitypupilh; 
	private String disabilitypupilht;
	private Long disabilityreflekcahaya; 
	private String disabilityreflekcahayam;
	private String disabilityreflekcahayak; 
	private String disabilityreflekcahayah; 
	private String disabilityreflekcahayaht;
	private Long disabilitydeformitas;
	private String disabilitydeformitasm;
	private String disabilitydeformitask;
	private String disabilitydeformitash;
	private String disabilitydeformitasht; 
	private String tindakanawala;
	private String tindakanawalb; 
	private String tindakanawalc; 
	private String tindakanawald; 
	private Long dokter; 
	private Long perawat;;
	private String ket; 
	

}
