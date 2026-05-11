package com.dev.generik.models.Gizi;

import com.dev.generik.entities.Gizi.FlowDetClass;

import jakarta.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

@IdClass(FlowDetClass.class)
@Getter
@Setter
public class FlowDetModel {
	
	private Long id;
	private String productID;	
	private Long qty;
//	private String diterima;	
//	private String ket;	
	

    // Constructors
    public FlowDetModel() {}

    public FlowDetModel(Long id, String productID, Long qty//, String diterima, String ket
    		) {
        this.id = id;
        this.productID = productID;
        this.qty = qty;
   //     this.diterima = diterima;
   //   this.ket =  ket;
    }
	
	
}
