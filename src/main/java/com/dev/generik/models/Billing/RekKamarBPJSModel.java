package com.dev.generik.models.Billing;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter

public class RekKamarBPJSModel {
	 private Long nomer;
	 private Long id;
	 private Long kelasid;
	 private LocalDate tmasuk;
	 private LocalDate tkeluar;
	 private Float lama;
	 private Float sewa;
	 private Float discount;
	 private String kelas;
	 private String roomname;
}
