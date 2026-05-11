package com.dev.generik.models.Gizi;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FlowDetModelView {
	private Long id;
    private String productID;
    private Long qty;
    private String diterima;	
	private String ket;	

    public FlowDetModelView(Long id, String productID, Long qty, String diterima, String ket) {
        this.id = id;
        this.productID = productID;
        this.qty = qty;
        this.diterima = diterima;
		this.ket =  ket;
    }
}
