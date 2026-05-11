package com.dev.generik.entities.ERM.Rad;

//import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSRADHASILPXCEK")
@Getter
@Setter
public class RadHasilPXCek {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "IDRAD")
	private Long idrad;
	

}
