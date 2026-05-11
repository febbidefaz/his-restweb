package com.dev.generik.entities.Inap;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/*import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape; */


@Entity
@Table(name = "WSPAVILIUN")

public class Paviliun {
			
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nama ;
	public Paviliun() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paviliun(Long id, String nama) {
		super();
		this.id = id;
		this.nama = nama;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}

	
	
	
	

}
