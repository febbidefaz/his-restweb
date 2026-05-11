package com.dev.generik.entities.Que;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSANTRIANKORJ")
@Getter
@Setter
public class AntrianKORJ {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date tgl;

	private String k;
	private String a;
	private String b;
	private String c;
	private String d;
	
}
