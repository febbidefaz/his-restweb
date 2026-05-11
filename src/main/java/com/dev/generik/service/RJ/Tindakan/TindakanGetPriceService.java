package com.dev.generik.service.RJ.Tindakan;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TindakanGetPriceService {
   /* @Autowired
    private TindakanGetPriceRepository tindakanGetPriceRepository;  
    public Double getPrice(int idReg, int tindakanId) {
        return tindakanGetPriceRepository.getPriceTindakan(idReg, tindakanId);
    } */
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public double getPrice(int idReg, int tindakanId) {
        return jdbcTemplate.execute(
            (Connection con) -> {
                CallableStatement cs = con.prepareCall("{call GetPrice_Tindakan_SP(?, ?, ?)}");
                cs.setInt(1, idReg);               // @IDREG
                cs.setInt(2, tindakanId);          // @TindakID
                cs.registerOutParameter(3, Types.FLOAT);  // @Price_Out OUTPUT
                return cs;
            },
            (CallableStatement cs) -> {
                cs.execute();
                return cs.getFloat(3); // ambil nilai OUTPUT
            }
        );
    }
}