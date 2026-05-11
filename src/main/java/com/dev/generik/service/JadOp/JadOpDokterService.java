package com.dev.generik.service.JadOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.JadOp.JadOpDokter;
import com.dev.generik.repository.ERM.JadOp.JadOpDokterRepository;

import java.util.List;

@Service
public class JadOpDokterService {
    @Autowired
    private JadOpDokterRepository jadOpDokterRepository;

    public List<JadOpDokter> getAll() {
       // Long IDlab = null;
		return jadOpDokterRepository.findAll();
    }
}