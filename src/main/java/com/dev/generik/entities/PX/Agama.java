package com.dev.generik.entities.PX;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WSAGAMA")

@Getter
@Setter
public class Agama {
	
	@Id
	//@GeneratedValue()
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;	
	
	@Column(name = "AGAMA")
	private String agama;
	
	public Long getId() {
        return id;
    }

}
