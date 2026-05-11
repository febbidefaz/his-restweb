package com.dev.generik.models.Obat;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObatAllItemModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1327129174809642351L;
	private String idd;
    private String kode;
    private String productName;
    private Float qty;            // atau Double
    private Float discount;
    private Float price;
    private Float totalLine;
    private Long id;
}
