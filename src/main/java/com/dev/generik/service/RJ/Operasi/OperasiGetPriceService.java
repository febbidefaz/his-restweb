package com.dev.generik.service.RJ.Operasi;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.RJ.Operasi.OperasiGetPrice;

@Service
public class OperasiGetPriceService {
   /* @Autowired
    private TindakanGetPriceRepository tindakanGetPriceRepository;  
    public Double getPrice(int idReg, int tindakanId) {
        return tindakanGetPriceRepository.getPriceTindakan(idReg, tindakanId);
    } */
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OperasiGetPrice getBiayaOperasi(Integer idReg, Integer opeId) {
        return jdbcTemplate.execute((Connection con) -> {
            CallableStatement cs = con.prepareCall("{call GetPrice_Operasi23_SP(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cs.setInt(1, idReg);
            cs.setInt(2, opeId);

            cs.registerOutParameter(3, Types.DOUBLE);
            cs.registerOutParameter(4, Types.DOUBLE);
            cs.registerOutParameter(5, Types.DOUBLE);
            cs.registerOutParameter(6, Types.DOUBLE);
            cs.registerOutParameter(7, Types.DOUBLE);
            cs.registerOutParameter(8, Types.DOUBLE);
            cs.registerOutParameter(9, Types.DOUBLE);
            cs.registerOutParameter(10, Types.DOUBLE);
            cs.registerOutParameter(11, Types.DOUBLE);

            cs.execute();

            OperasiGetPrice dto = new OperasiGetPrice();
            dto.setOperatorOut(cs.getDouble(3));
            dto.setAnestesiOut(cs.getDouble(4));
            dto.setAssOut(cs.getDouble(5));
            dto.setAlatOut(cs.getDouble(6));
            dto.setBahanOut(cs.getDouble(7));
            dto.setOkRROut(cs.getDouble(8));
            dto.setAssAnesOut(cs.getDouble(9));
            dto.setJasaOut(cs.getDouble(10));
            dto.setCssdOut(cs.getDouble(11));

            return dto;
        });
    }
}