package com.dev.generik.service.JadOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.JadOp.JadOpStatus;
import com.dev.generik.repository.ERM.JadOp.JadOpStatusRepository;

import java.util.List;

@Service
public class JadOpStatusService {
    @Autowired
    private JadOpStatusRepository jadOpStatusRepository;

    public List<JadOpStatus> getAll() {
       // Long IDlab = null;
		return jadOpStatusRepository.findAll();
    }
}