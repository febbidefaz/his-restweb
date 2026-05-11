package com.dev.generik.entities.HaloRSA;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import javax.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import org.springframework.lang.NonNull;
//import org.springframework.lang.Nullable;

@Entity
@Table(name = "RATINGREG")
@Getter
@Setter
public class RatingRegNew {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id;

	@Column(name = "Kd")
	@NonNull
	private Long kd;

	@Column(name = "Star")
	@NonNull
	private Long star;

	@Column(name = "Ketstar")
	@NonNull
	private String ketstar;

	@Column(name = "Tgl")
	@Temporal(TemporalType.DATE)
	private Date tgl;


}
