package com.dev.generik.entities.ERM.SP;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/*import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter; */
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "WSSPRADGET")

@Getter
@Setter

public class SPRadGet {

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
	private Boolean ivp;
	
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
	private Boolean ctkepala;
	
	@Column(name = "CTKEPALADGKONTRAS")
	private Boolean ctkepalaDgKontras;
	
	@Column(name = "CTTHORAX")
	private Boolean ctthorax;
	
	@Column(name = "CTTHORAXDGKONTRAS")
	private Boolean ctthoraxDgKontras;
	
	@Column(name = "CTUPLOABDO")
	private Boolean ctupLoAbdo;
	
	@Column(name = "MRIKEPALA")
	private Boolean mriKepala;
	
	@Column(name = "MRICERVICAL")
	private Boolean mriCervical;
	
	@Column(name = "MRITHORACAL")
	private Boolean mriThoracal;
	
	@Column(name = "MRILUMBAL")
	private Boolean mriLumbal;
	
	@Column(name = "MRIABDOMENATBAW")
	private Boolean mriAbdomenAtBaw;
	
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
		
	@Column(name = "LAIN")
	private String lain;
	
	@Column(name = "KELASID")
	private Long kelasID;
	
	@Column(name = "ROOMID")
	private Long roomID;
	
	@Column(name = "SENT")
	private Boolean sent;
	
	@Column(name = "PROSES")
	private Boolean proses;
	
	@Column(name = "Diagnosa")
	private String diagnosa;
	
	@Column(name = "KETCANCEL")
	private String ketCancel;
	
	@Column(name = "KETCANCELKODE")
	private Long ketCancelKode;
	
	@Column(name = "KETINAP")
	private String ketInap;
}

