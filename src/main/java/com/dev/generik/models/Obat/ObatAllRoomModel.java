package com.dev.generik.models.Obat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObatAllRoomModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9086751531667488583L;
	 	private Long roomID;
	    private String roomName;
	 //   private Long id;
	    private LocalDate invoiceDate;
	    private List<ObatAllItemModel> items;
}
