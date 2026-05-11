package com.dev.generik.entities.display;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSKEPSIFT")
@Getter
@Setter
public class DisplayInapSift {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KNIP")
	private String nip;
	
	@Column(name = "KNAMA")
	private String nama;
	
	@Column(name = "PHOTO")
	private byte[] foto;
	//private String foto;
	
	@Column(name = "US")
	private String user;
	
	@Column(name = "SIFT")
	private String sift;
	
	@Column(name = "PAV")
	private String PAVILIUN;

}
