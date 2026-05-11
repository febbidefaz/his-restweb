package com.dev.generik.models.Register;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegisterKepRIGetModel {
	private Long id;
	private Long no;	
	private String penerima;
	private String telp;
	
	public RegisterKepRIGetModel(Long id, Long no, String penerima, String telp) {
		this.id = id;
		this.no = no;				
		this.penerima = penerima;
		this.telp = telp;
	}
}
