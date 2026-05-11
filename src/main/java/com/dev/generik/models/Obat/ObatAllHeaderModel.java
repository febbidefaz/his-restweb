package com.dev.generik.models.Obat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObatAllHeaderModel implements  Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = -5193731757256104417L;
	private String regNum;
	   private String namaPx;
	   private String addr;
	   private LocalDate tanggalLahir;
	   private String telepon;
	   private Float tunai;     // boleh Double, tapi BigDecimal lebih aman untuk uang
	   private String kelurahan;
	   private List<ObatAllRoomModel> rooms;
}
