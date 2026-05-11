package com.dev.generik.entities.ERM.SP;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "WSSPLABGET")

@Getter
@Setter


public class SPLabGet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NO")
	private Long no;

	@Column(name = "ID")
	private Long id;
	
	@Column(name = "IDDOKTER")
	private Long idDokter;
	
	@Column(name = "OK")
	private Boolean ok;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TGL")
	private Date tgl; 
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.TIME)
	@Column(name = "JAM")
	private Date jam;
	
	@Column(name = "HEDL")
	private Boolean heDL;
	
	@Column(name = "HEHemo")
	private Boolean heHemo;
	
	@Column(name = "HELeko")
	private Boolean heLeko;
	
	@Column(name = "HEHema")
	private Boolean heHema;
	
	@Column(name = "HEEri")
	private Boolean heEri;
	
	@Column(name = "HELAJUENDA")
	private Boolean heLajuEnDa;
	
	@Column(name = "HETrombo")
	private Boolean heTrombo;
	
	@Column(name = "HEReti")
	private Boolean heReti;
	
	@Column(name = "HEHitung")
	private Boolean heHitung;
	
	@Column(name = "HESerum")
	private Boolean heSerum;
	
	@Column(name = "HETIBC")
	private Boolean heTIBC;
	
	@Column(name = "FHELPPT")
	private Boolean fhelPPT;
	
	@Column(name = "FHEAPTT")
	private Boolean fheAPTT;
	
	@Column(name = "FHECT")
	private Boolean fheCT;
	
	@Column(name = "FHEBT")
	private Boolean fheBT;
	
	@Column(name = "FHEINR")
	private Boolean fheINR;
	
	@Column(name = "FHEGOLDAR")
	private Boolean fheGolDar;
	
	@Column(name = "FHEGOLDARRE")
	private Boolean fheGolDarRe;
	
	@Column(name = "FHEHAPUSANDAR")
	private Boolean fheHapusanDar;
	
	@Column(name = "UL")
	private Boolean ul;
	
	@Column(name = "FCESFL")
	private Boolean fcesFL;	
	
	@Column(name = "FCESBENZI")
	private Boolean fcesBenzi;
	
	@Column(name = "FHABILITOTAL")
	private Boolean fhaBiliTotal;
	
	@Column(name = "FHABILIDEREK")
	private Boolean fhaBiliDerek;
	
	@Column(name = "FHABILIINDEREK")
	private Boolean fhaBiliInDerek;
	
	@Column(name = "FHASGOT")
	private Boolean fhaSGOT;
	
	@Column(name = "FHASGPT")
	private Boolean fhaSGPT;
	
	@Column(name = "FHAAlkALI")
	private Boolean fhaAlkali;
	
	@Column(name = "FHATOTALPRO")
	private Boolean fhaTotalPro;
	
	@Column(name = "FHAALBU")
	private Boolean fhaAlbu;
	
	@Column(name = "FHAGLO")
	private Boolean fhaGlo;
	
	@Column(name = "FGINKRE")
	private Boolean fginKre;
	
	@Column(name = "FGINUREUN")
	private Boolean fginUreun;
	
	@Column(name = "FGINURIDACID")
	private Boolean fginUridAcid;
	
	@Column(name = "LEMDARChOLE")
	private Boolean lemDarChole;
	
	@Column(name = "LEMDARHDL")
	private Boolean lemDarHDL;
	
	@Column(name = "LEMDARLDL")
	private Boolean lemDarLDL;
	
	@Column(name = "LEMDARTRI")
	private Boolean lemDarTri;
	
	@Column(name = "GDGlU")
	private Boolean gdglu;
	
	@Column(name = "GDGLU2JAM")
	private Boolean gdglu2jam;
	
	@Column(name = "GDGLUSESAAT")
	private Boolean gdglusesaat;
	
	@Column(name = "GDHBA1C")
	private Boolean gdhbA1c;
	
	@Column(name = "Ele")
	private Boolean ele;
	
	@Column(name = "ElENAT")
	private Boolean eleNat;
	
	@Column(name = "ELEKAL")
	private Boolean eleKal;
	
	@Column(name = "ELECLO")
	private Boolean eleClo;
	
	@Column(name = "ELECAL")
	private Boolean eleCal;
	
	@Column(name = "IMHBSAG")
	private Boolean imHBsAg;
	
	@Column(name = "IMANHBS")
	private Boolean imAnHBs;
	
	@Column(name = "IMHBSAGTITER")
	private Boolean imHBsAgTiter;
	
	@Column(name = "IMANHBSAGTITER")
	private Boolean imAnHBsAgTiter;
	
	@Column(name = "IMANHCV")
	private Boolean imAnHCV;
	
	@Column(name = "IMANHAVIGG")
	private Boolean imAnHAVIgG;
	
	@Column(name = "IMANIGM")
	private Boolean imAnIgM;
	
	@Column(name = "IMINWIDAL")
	private Boolean iminWidal;
	
	@Column(name = "IMINANTIDHF")
	private Boolean iminAntiDhf;
	
	@Column(name = "IMINVDRL")
	private Boolean iminVDRL;
	
	@Column(name = "IMINANTIHIV")
	private Boolean iminAntiHIV;
	
	@Column(name = "IMINMALA")
	private Boolean iminMala;
	
	@Column(name = "IMINSCREHIV")
	private Boolean iminScreHIV;
	
	@Column(name = "IMINASO")
	private Boolean iminASO;
	
	@Column(name = "IMINCRP")
	private Boolean iminCRP;
	
	@Column(name = "IMINANA")
	private Boolean iminAna;
	
	@Column(name = "IMINTUBEX")
	private Boolean iminTubex;
	
	@Column(name = "IMINMANTOUX")
	private Boolean iminMantoux;
	
	@Column(name = "IMINIGGANTOXO")
	private Boolean iminigGAnToxo;
	
	@Column(name = "IMINIGMANTOXO")
	private Boolean iminigMAnToxo;
	
	@Column(name = "IMINIGGANRUB")
	private Boolean iminigGAnRub;
	
	@Column(name = "IMINIGMANRUB")
	private Boolean iminigMAnRub;
	
	@Column(name = "IMINIGGANCMV")
	private Boolean iminigGAnCMV;
	
	@Column(name = "IMINIGMANCMV")
	private Boolean iminigMAnCMV;
	
	@Column(name = "IMINIGGANHSV1")
	private Boolean iminigGAnHSV1;
	
	@Column(name = "IMINIGMANHSV1")
	private Boolean iminigMAnHSV1;
	
	@Column(name = "IMINIGGANHSV2")
	private Boolean iminigGAnHSV2;
	
	@Column(name = "IMINIGMANHSV2")
	private Boolean iminigMAnHSV2;
	
	@Column(name = "HAMPLANO")
	private Boolean hamPlano;
	
	@Column(name = "HAMTESTPACK")
	private Boolean hamTestPack;
	
	@Column(name = "HAMPLANOPENGEN")
	private Boolean hamPlanoPengen;
	
	@Column(name = "TUMAFP")
	private Boolean tumAFP;
	
	@Column(name = "TUMCEA")
	private Boolean tumCEA;
	
	@Column(name = "TUMPSA")
	private Boolean tumPSA;
	
	@Column(name = "TUMCA125")
	private Boolean tumCa125;
	
	@Column(name = "TUMCA19")
	private Boolean tumCa19;
	
	@Column(name = "TIRTSH")
	private Boolean tirTSH;
	
	@Column(name = "TIRFT3")
	private Boolean tirFT3;
	
	@Column(name = "TIRFT4")
	private Boolean tirFT4;
	
	@Column(name = "JANTROP")
	private Boolean janTrop;
	
	@Column(name = "JANOK")
	private Boolean janOk;
	
	@Column(name = "JANTROPI")
	private Boolean janTropI;
	
	@Column(name = "MIKZN")
	private Boolean mikZN;
	
	@Column(name = "MIKNEIS")
	private Boolean mikNeis;
	
	@Column(name = "MIKGRAM")
	private Boolean mikGram;
	
	@Column(name = "MIKMAL")
	private Boolean mikMal;
	
	@Column(name = "MIKKULDAR")
	private Boolean mikKulDar;
	
	@Column(name = "MIKKULUR")
	private Boolean mikKulUr;
	
	@Column(name = "MIKSPU")
	private Boolean mikSpu;
	
	@Column(name = "GD")
	private Boolean gd;
	
	@Column(name = "LAINANSPER")
	private Boolean lainAnSper;
	
	@Column(name = "LAINANBATGIN")
	private Boolean lainAnBatGin;
	
	@Column(name = "LAINRAP")
	private Boolean lainRap;
	
	@Column(name = "LAINODIM")
	private Boolean lainODim;
	
	@Column(name = "Inap")
	private Boolean inap;
	
	@Column(name = "Lain")
	private String lain;
	
	@Column(name = "KelasID")
	private Long kelasID;
	
	@Column(name = "RoomID")
	private Long roomID;
	
	@Column(name = "Sent")
	private Boolean sent;
	
	@Column(name = "Proses")
	private Boolean proses;
	
	@Column(name = "Diagnosa")
	private String diagnosa;
	
	@Column(name = "KETCANCEL")
	private String ketCancel;
	
	@Column(name = "KETCANCELKODE")
	private Long ketCancelKode;
	
	@Column(name = "KETINAP")
	private String ketInap;
	
	@Column(name = "BB")
	private Float bb;
}

