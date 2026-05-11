package com.dev.generik.entities.ERM.Resep;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ObAtRspClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String kode;

    // Constructor
    public ObAtRspClass() {}

    public ObAtRspClass(Long id, String kode) {
        this.id = id;
        this.kode = kode;
    }

    // Getters and Setters

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObAtRspClass that = (ObAtRspClass) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(kode, that.kode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kode);
    }
}
