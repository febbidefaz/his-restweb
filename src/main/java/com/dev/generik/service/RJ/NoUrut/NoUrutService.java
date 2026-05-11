package com.dev.generik.service.RJ.NoUrut;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.RJ.NoUrut.ListNoUrut;

@Service
public class NoUrutService {
      
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
	public List<ListNoUrut> getDaftarPasien(Date bDate, String subLayanan, Long dokterID, String jp) {
        String sql = "EXEC DaftarPasienRawatJalanUserDrKd_sp ?, ?, ?, ?";
        return jdbcTemplate.query(sql, new Object[]{bDate, subLayanan, dokterID, jp}, (rs, rowNum) -> {
        	ListNoUrut dto = new ListNoUrut();
            dto.setPxNo(rs.getLong("PxNo"));
            dto.setRegNum(rs.getString("RegNum"));
            dto.setNama(rs.getString("Nama"));
            dto.setPoly(rs.getString("Poly"));
            dto.setTgl(rs.getTimestamp("TGL"));
            dto.setJp(rs.getString("Alias"));
            dto.setId(rs.getLong("ID"));
            dto.setCallNo(rs.getLong("call_No"));
       //     dto.setDatang(rs.getBoolean("Datang"));
       //     dto.setFollowUp(rs.getString("FollowUp"));
            dto.setIdq(rs.getLong("idq"));
            dto.setJamPraktek(rs.getLong("jam_praktek"));
            dto.setIsLock(rs.getBoolean("is_Lock"));
            return dto;
        });
    }
}