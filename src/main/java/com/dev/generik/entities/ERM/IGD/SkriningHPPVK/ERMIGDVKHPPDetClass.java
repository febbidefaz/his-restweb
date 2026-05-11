package com.dev.generik.entities.ERM.IGD.SkriningHPPVK;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ERMIGDVKHPPDetClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;  
	private Long nama;

    // Constructor
    public ERMIGDVKHPPDetClass() {}

    public ERMIGDVKHPPDetClass(Long id, Long nama) {
    	this.id = id;
    	this.nama = nama;     
    }

    // Getters and Setters

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ERMIGDVKHPPDetClass that = (ERMIGDVKHPPDetClass) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(nama, that.nama);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama);
    }
}
