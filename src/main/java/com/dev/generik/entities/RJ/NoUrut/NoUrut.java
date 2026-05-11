package com.dev.generik.entities.RJ.NoUrut;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "THERAPY")
@Getter
@Setter

public class NoUrut {
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "PXNO")
	private Long pxNo;	
			
}
