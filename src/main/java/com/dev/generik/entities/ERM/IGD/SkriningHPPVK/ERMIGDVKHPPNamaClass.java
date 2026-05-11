package com.dev.generik.entities.ERM.IGD.SkriningHPPVK;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ERMIGDVKHPPNamaClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idKel;
	private Long id;    

    // Constructor
    public ERMIGDVKHPPNamaClass() {}

    public ERMIGDVKHPPNamaClass(Long idKel, Long id) {
    	this.idKel = idKel;
    	this.id = id;     
    }

    // Getters and Setters

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ERMIGDVKHPPNamaClass that = (ERMIGDVKHPPNamaClass) o;
        return Objects.equals(idKel, that.idKel) &&
               Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKel, id);
    }
}
