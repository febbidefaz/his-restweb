package com.dev.generik.entities.Dokter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WSSPECIALIST")
public class Specialist {
	@Id
	@Column(name = "Id")
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Category")
	private String category;

	@Column(name = "FotoOL")
	private String fotoOL;

	@Column(name = "LayID")
	private Long layID;
	
	@Column(name = "KDBPJS")
	private String kdBPJS;

	@Lob
	@Column(name="Foto")
	private byte[] foto;

}
