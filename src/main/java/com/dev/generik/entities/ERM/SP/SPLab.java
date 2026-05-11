package com.dev.generik.entities.ERM.SP;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "LABORATPLANWS")

@Getter
@Setter
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateSPLab", procedureName = "UpdateSPLab_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NO", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDDokter", type = Long.class),
			//	@StoredProcedureParameter(mode = ParameterMode.IN, name = "OK", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TGL", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Jam", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeDL", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeHemo", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeLeko", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeHema", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeEri", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeLajuEnDa", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeTrombo", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeReti", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeHitung", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeSerum", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HeTIBC", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHelPPT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHeAPTT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHeCT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHeBT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHeINR", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHeGolDar", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHeGolDarRe", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHeHapusanDar", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "UL", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FcesFL", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FcesBenzi", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHaBiliTotal", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHaBiliDerek", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHaBiliInDerek", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHaSGOT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHaSGPT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHaAlkali", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHaTotalPro", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHaAlbu", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FHaGlo", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FGinKre", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FGinUreun", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FGinUridAcid", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LemDarChole", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LemDarHDL", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LemDarLDL", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LemDarTri", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GDGlu", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GDGlu2jam", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GDGlusesaat", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GDHbA1c", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Ele", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "EleNat", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "EleKal", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "EleClo", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "EleCal", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImHBsAg", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImAnHBs", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImHBsAgTiter", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImAnHBsAgTiter", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImAnHCV", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImAnHAVIgG", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImAnIgM", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInWidal", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInAntiDhf", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInVDRL", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInAntiHIV", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInMala", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInScreHIV", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInASO", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInCRP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInAna", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInTubex", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInMantoux", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgGAnToxo", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgMAnToxo", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgGAnRub", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgMAnRub", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgGAnCMV", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgMAnCMV", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgGAnHSV1", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgMAnHSV1", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgGAnHSV2", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ImInIgMAnHSV2", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HamPlano", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HamTestPack", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HamPlanoPengen", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TumAFP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TumCEA", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TumPSA", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TumCa125", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TumCa19", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TirTSH", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TirFT3", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TirFT4", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "JanTrop", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "JanOk", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "JanTropI", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikZN", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikNeis", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikGram", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikMal", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikKulDar", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikKulUr", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MikSpu", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GD", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LainAnSper", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LainAnBatGin", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LainRap", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LainODim", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Lain", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Diagnosa", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "BB", type = Float.class),
				}) })

public class SPLab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NO")
	private Long no;

	@Column(name = "ID")
	private Long id;
	
	@Column(name = "IDDOKTER")
	private Long idDokter;
	
//	@Column(name = "OK")
//	private Boolean ok;

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
	
//	@Column(name = "Sent")
//	private Boolean sent;
	
//	@Column(name = "Proses")
//	private Boolean proses;
	
	@Column(name = "Diagnosa")
	private String diagnosa;
	
	@Column(name = "KETINAP")
	private String ketInap;
	
	@Column(name = "BB")
	private Float bb;
}

