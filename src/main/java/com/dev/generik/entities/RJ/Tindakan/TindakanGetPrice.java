package com.dev.generik.entities.RJ.Tindakan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "WSLABHASILBATAS1")
@Getter
@Setter
public class TindakanGetPrice {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDREG")
	private Long idReg;
	
	@Column(name = "TINDAKID")
	private Long tindakID;
	
	@Column(name = "PRICE_OUT")
	private Long priceOut;
	
}
