package com.dev.generik.entities.ERM.Lab;

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
@Table(name = "WSLABHASILBATASCEK")
@Getter
@Setter
public class LabHasilBatasPXCek {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "IDLAB")
	private Long idlab;
	

}
