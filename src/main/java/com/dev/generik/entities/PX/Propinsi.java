package com.dev.generik.entities.PX;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Kabupaten")
@Getter
@Setter
public class Propinsi {
	
	@Id	
	private Long id;
	private String propinsi;


}
