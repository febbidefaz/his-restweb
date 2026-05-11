package com.dev.generik.entities.ERM.Resep;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ContensTabClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String mfdtd;
    private String kode;

    // Constructor
    public ContensTabClass() {}

    public ContensTabClass(Long id, String mfdtd, String kode) {
        this.id = id;
        this.mfdtd = mfdtd;
        this.kode = kode;
    }

    // Getters and Setters

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContensTabClass that = (ContensTabClass) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(kode, that.kode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kode);
    }
}
