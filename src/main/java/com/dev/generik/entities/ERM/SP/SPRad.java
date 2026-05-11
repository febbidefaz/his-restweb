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
@Table(name = "RADIOLOGIPLANWS")

@Getter
@Setter
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "UpdateSPRad", procedureName = "UpdateSPRad_sp", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "NO", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ID", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDDokter", type = Long.class),
			//	@StoredProcedureParameter(mode = ParameterMode.IN, name = "OK", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "TGL", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Jam", type = Date.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "SkullAP", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "SkullLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "WatersAP", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "WatersLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VerCerAP", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VerCerLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VerCerOBQ", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VerThoAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VerThoLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VerThoOBQ", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VerLumAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VerLumLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "VerLumOBQ", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ClaAP", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ClaLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ThoAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ThoLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CosAP", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CosLAT", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ShoAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ShoLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HumAP", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HumLAT", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CubAP", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CubLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AntAP", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AntLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "WristAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "WristLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ManAP", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ManLAT", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AbdoAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AbdoLAT", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PelAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PelLAT", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FeAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FeLAT", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GeAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GeLAT", type = Boolean.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CruAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CruLAT", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AngAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AngLAT", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PedAP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PedLAT", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "IVP", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Cysto", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Uret", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Barium", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "KepalaBayi", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Mata", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Thyroid", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Mammae", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "UpperAb", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "LowerAb", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Urologi", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Testis", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Muscul", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CTKepala", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CTKepalaDgKontras", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CTThorax", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CTThoraxDgKontras", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CTUpLoAbdo", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MRIKepala", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MRICervical", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MRIThoracal", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MRILumbal", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MRIAbdomenAtBaw", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "MRIEkstrem", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Lain", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "KelasID", type = Long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "RoomID", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "Diagnosa", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ClaAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ClaLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CosAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CosLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ShoAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ShoLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HumAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HumLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AntAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AntLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "WristAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "WristLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ManAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "ManLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FeAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "FeLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GeAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "GeLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CruAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "CruLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AngAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "AngLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PedAPS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "PedLATS", type = Boolean.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "HSG", type = Boolean.class), 
				}) })

public class SPRad {

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
	
	@Column(name = "SKULLAP")
	private Boolean skullAP;
	
	@Column(name = "SKULLLAT")
	private Boolean skullLAT;
	
	@Column(name = "WATERSAP")
	private Boolean watersAP;
	
	@Column(name = "WATERSLAT")
	private Boolean watersLAT;
	
	@Column(name = "VERCERAP")
	private Boolean verCerAP;
	
	@Column(name = "VERCERLAT")
	private Boolean verCerLAT;
	
	@Column(name = "VERCEROBQ")
	private Boolean verCerOBQ;
	
	@Column(name = "VERTHOAP")
	private Boolean verThoAP;
	
	@Column(name = "VERTHOLAT")
	private Boolean verThoLAT;
	
	@Column(name = "VERTHOOBQ")
	private Boolean verThoOBQ;
	
	@Column(name = "VERLUMAP")
	private Boolean verLumAP;
	
	@Column(name = "VERLUMLAT")
	private Boolean verLumLAT;
	
	@Column(name = "VERLUMOBQ")
	private Boolean verLumOBQ;
	
	@Column(name = "CLAAP")
	private Boolean claAP;
	
	@Column(name = "CLALAT")
	private Boolean claLAT;
	
	@Column(name = "THOAP")
	private Boolean thoAP;
	
	@Column(name = "THOLAT")
	private Boolean thoLAT;
	
	@Column(name = "COSAP")
	private Boolean cosAP;
	
	@Column(name = "COSLAT")
	private Boolean cosLAT;
	
	@Column(name = "SHOAP")
	private Boolean shoAP;
	
	@Column(name = "SHOLAT")
	private Boolean shoLAT;	
	
	@Column(name = "HUMAP")
	private Boolean humAP;
	
	@Column(name = "HUMLAT")
	private Boolean humLAT;
	
	@Column(name = "CUBAP")
	private Boolean cubAP;
	
	@Column(name = "CUBLAT")
	private Boolean cubLAT;
	
	@Column(name = "ANTAP")
	private Boolean antAP;
	
	@Column(name = "ANTLAT")
	private Boolean antLAT;
	
	@Column(name = "WRISTAP")
	private Boolean wristAP;
	
	@Column(name = "WRISTLAT")
	private Boolean wristLAT;
	
	@Column(name = "MANAP")
	private Boolean manAP;
	
	@Column(name = "MANLAT")
	private Boolean manLAT;
	
	@Column(name = "ABDOAP")
	private Boolean abdoAP;
	
	@Column(name = "ABDOLAT")
	private Boolean abdoLAT;
	
	@Column(name = "PELAP")
	private Boolean pelAP;
	
	@Column(name = "PELLAT")
	private Boolean pelLAT;
	
	@Column(name = "FEAP")
	private Boolean feAP;
	
	@Column(name = "FELAT")
	private Boolean feLAT;
	
	@Column(name = "GEAP")
	private Boolean geAP;
	
	@Column(name = "GELAT")
	private Boolean geLAT;
	
	@Column(name = "CRUAP")
	private Boolean cruAP;
	
	@Column(name = "CRULAT")
	private Boolean cruLAT;
	
	@Column(name = "ANGAP")
	private Boolean angAP;
	
	@Column(name = "ANGLAT")
	private Boolean angLAT;
	
	@Column(name = "PEDAP")
	private Boolean pedAP;
	
	@Column(name = "PEDLAT")
	private Boolean pedLAT;
	
	@Column(name = "IVP")
	private Boolean iVP;
	
	@Column(name = "CYSTO")
	private Boolean cysto;
	
	@Column(name = "URET")
	private Boolean uret;
	
	@Column(name = "BARIUM")
	private Boolean barium;
	
	@Column(name = "KEPALABAYI")
	private Boolean kepalaBayi;
	
	@Column(name = "MATA")
	private Boolean mata;
	
	@Column(name = "THYROID")
	private Boolean thyroid;
	
	@Column(name = "MAMMAE")
	private Boolean mammae;
	
	@Column(name = "UPPERAB")
	private Boolean upperAb;
	
	@Column(name = "LOWERAB")
	private Boolean lowerAb;
	
	@Column(name = "UROLOGI")
	private Boolean urologi;
	
	@Column(name = "TESTIS")
	private Boolean testis;
	
	@Column(name = "MUSCUL")
	private Boolean muscul;
	
	@Column(name = "CTKEPALA")
	private Boolean cTKepala;
	
	@Column(name = "CTKEPALADGKONTRAS")
	private Boolean cTKepalaDgKontras;
	
	@Column(name = "CTTHORAX")
	private Boolean cTThorax;
	
	@Column(name = "CTTHORAXDGKONTRAS")
	private Boolean cTThoraxDgKontras;
	
	@Column(name = "CTUPLOABDO")
	private Boolean cTUpLoAbdo;
	
	@Column(name = "MRIKEPALA")
	private Boolean mRIKepala;
	
	@Column(name = "MRICERVICAL")
	private Boolean mRICervical;
	
	@Column(name = "MRITHORACAL")
	private Boolean mRIThoracal;
	
	@Column(name = "MRILUMBAL")
	private Boolean mRILumbal;
	
	@Column(name = "MRIABDOMENATBAW")
	private Boolean mRIAbdomenAtBaw;
	
	@Column(name = "MRIEKSTREM")
	private Boolean mRIEkstrem;
	
	@Column(name = "CLAAPS")
	private Boolean claAPS;
	
	@Column(name = "CLALATS")
	private Boolean claLATS;
	
	@Column(name = "COSAPS")
	private Boolean cosAPS;
	
	@Column(name = "COSLATS")
	private Boolean cosLATS;
	
	@Column(name = "SHOAPS")
	private Boolean shoAPS;
	
	@Column(name = "SHOLATS")
	private Boolean shoLATS;
	
	@Column(name = "HUMAPS")
	private Boolean humAPS;
	
	@Column(name = "HUMLATS")
	private Boolean humLATS;
	
	@Column(name = "ANTAPS")
	private Boolean antAPS;
	
	@Column(name = "ANTLATS")
	private Boolean antLATS;
	
	@Column(name = "WRISTAPS")
	private Boolean wristAPS;
	
	@Column(name = "WRISTLATS")
	private Boolean wristLATS;
	
	@Column(name = "MANAPS")
	private Boolean manAPS;
	
	@Column(name = "MANLATS")
	private Boolean manLATS;
	
	@Column(name = "FEAPS")
	private Boolean feAPS;
	
	@Column(name = "FELATS")
	private Boolean feLATS;
	
	@Column(name = "GEAPS")
	private Boolean geAPS;
	
	@Column(name = "GELATS")
	private Boolean geLATS;
	
	@Column(name = "CRUAPS")
	private Boolean cruAPS;
	
	@Column(name = "CRULATS")
	private Boolean cruLATS;
	
	@Column(name = "ANGAPS")
	private Boolean angAPS;
	
	@Column(name = "ANGLATS")
	private Boolean angLATS;
	
	@Column(name = "PEDAPS")
	private Boolean pedAPS;
	
	@Column(name = "PEDLATS")
	private Boolean pedLATS;
	
	@Column(name = "HSG")
	private Boolean hsg;
		
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
	
}

