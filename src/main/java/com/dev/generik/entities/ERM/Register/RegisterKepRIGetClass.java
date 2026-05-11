package com.dev.generik.entities.ERM.Register;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegisterKepRIGetClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id; 
	private Long no;
  

    // Constructor
    public RegisterKepRIGetClass() {}

    public RegisterKepRIGetClass(Long id, Long no) {
    	this.id = id;
    	this.no = no;    	
    }

    // Getters and Setters

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterKepRIGetClass that = (RegisterKepRIGetClass) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(no, that.no);
    }

    @Override
    public int hashCode() {
      //  return Objects.hash(id, no);
        int result = no.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}
