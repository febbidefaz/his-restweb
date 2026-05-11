package com.dev.generik.entities.Obat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "OBATUNIONA")
@Getter
@Setter
public class ObatUnion {
	@Id
	@Column(name = "NEWID")
	private Long id;

	@Column(name = "ROOMNAME")
	private String room;

	@Column(name = "IDREG")
	private Long idReg;

}