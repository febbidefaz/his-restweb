package com.dev.generik.entities.ERM.Lab;

//import java.sql.Date;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "WSLABHASILBATAS1")
@Getter
@Setter
public class LabHasilBatasList {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDLAB")
	private Long idlab;
	
	@Column(name = "IDREG")
	private Long idreg;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd MMMM yyyy", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "TLAB")
	private Date tlab; 		

}
