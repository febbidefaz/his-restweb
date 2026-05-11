package com.dev.generik.models.RJ;
import lombok.Getter;
import lombok.Setter;

//import com.dev.generik.bpjs.entities.SurgeryBooking;
@Getter
@Setter

public class OperasiGetPriceModel {
private Double operatorOut;
private Double anestesiOut;
private Double assOut;
private Double alatOut;
private Double bahanOut;
private Double okRROut;
private Double assAnesOut;
private Double jasaOut;
private Double cssdOut;

// ✅ Konstruktor lengkap (9 parameter)
public OperasiGetPriceModel(Double operatorOut, Double anestesiOut, Double assOut, Double alatOut,
                       Double bahanOut, Double okRROut, Double assAnesOut, Double jasaOut, Double cssdOut) {
    this.operatorOut = operatorOut;
    this.anestesiOut = anestesiOut;
    this.assOut = assOut;
    this.alatOut = alatOut;
    this.bahanOut = bahanOut;
    this.okRROut = okRROut;
    this.assAnesOut = assAnesOut;
    this.jasaOut = jasaOut;
    this.cssdOut = cssdOut;
}
}
