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
@Table(name = "WSERMIGDPENGKAJIANAWALFUNGJATUHPOPULASIEDUKASI")
@Getter
@Setter
public class ERMIGDPengkajianAwalFungJatuhPopulasiEdukasi {
	@Id
	
	private Long id;
	private Long docid;
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	@Temporal(TemporalType.TIME)
	private Date jam;
	private Long fungskalabarthelindeks;
	private Long jatmorse;
	private Long jathumptydumpty;
	private Long jatgetupandgo;
	private Long popxkhusus;
	private Long edbahasa; 
	private String edbahasatext; 
	private Long edkebituhanpenerjemah; 
	private Long edbacadantulis; 
	private Long edpilihantipepembelajaran; 
	private Long edhambatanedukasi; 
	private String edhambatanedukasitext;
	private Long edkebutuhanpembelajaranpasien;
	private String edkebutuhanpembelajaranpasientext;
	


}
