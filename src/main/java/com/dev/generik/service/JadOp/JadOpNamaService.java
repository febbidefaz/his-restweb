package com.dev.generik.service.JadOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.JadOp.JadOpNama;
import com.dev.generik.repository.ERM.JadOp.JadOpNamaRepository;

import java.util.List;

@Service
public class JadOpNamaService {
    @Autowired
    private JadOpNamaRepository jadOpNamaRepository;

    public List<JadOpNama> getAll() {
       // Long IDlab = null;
		return jadOpNamaRepository.findAll();
    }
}