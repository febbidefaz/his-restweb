package com.dev.generik.entities.Gizi;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FlowDetClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String productID;

    // Constructor
    public FlowDetClass() {}

    public FlowDetClass(Long id, String productID) {
        this.id = id;
        this.productID = productID;
    }

    // Getters and Setters

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowDetClass that = (FlowDetClass) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(productID, that.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productID);
    }
}
