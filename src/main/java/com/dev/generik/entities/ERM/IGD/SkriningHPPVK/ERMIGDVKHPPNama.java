package com.dev.generik.entities.ERM.IGD.SkriningHPPVK;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RISIKOHPPADMISINPERSALINANNAMA")
@IdClass(ERMIGDVKHPPNamaClass.class)
@Getter
@Setter
public class ERMIGDVKHPPNama {
	
	@Id
	@Column(name = "IDKEL")
	private Long idKel;	
	@Id
	private Long id;
	private String nama;
	


}
