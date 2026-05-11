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
@Table(name = "WSERMIGDPENGKAJIANAWALPSIKOEKONOMINUTRISI")
@Getter
@Setter
public class ERMIGDPengkajianAwalPsikoEkoNut {
	@Id
	

	private Long id;
	private Long docid;
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	@Temporal(TemporalType.TIME)
	private Date jam;
	private Long psipersespiterhadapsakitnya;
	private String psipersespiterhadapsakitnyatext; 
	private Long psicurigapenganiayaan;
	private String psicurigapenganiayaantext; 
	private Long psistatusemosional; 
	private Long psikebutuhanprivasi; 
	private String psikebutuhanprivasitext; 
	private Long psikepercayaankhusussosialbudaya; 
	private String psikepercayaankhusussosialbudayatext; 
	private Long psikebiasaanberibadah; 
	private Long ekotempattinggal; 
	private String ekotempattinggaltext; 
	private Long ekokeluarga; 
	private String ekokeluargatext; 
	private String nutlila; 
	private String nutlikep; 
	private Long nutscoredew; 
	private Long nutscoreanak;


	
	

}
