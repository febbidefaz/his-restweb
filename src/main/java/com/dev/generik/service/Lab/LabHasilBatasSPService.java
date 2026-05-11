package com.dev.generik.service.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.Lab.LabHasilBatasSP;
import com.dev.generik.repository.ERM.Lab.LabHasilBatasSPRepository;

import java.util.List;

@Service
public class LabHasilBatasSPService {
    @Autowired
    private LabHasilBatasSPRepository labHasilBatasSPRepository;

    public List<LabHasilBatasSP> getByidlab(Long idlab) {
       // Long IDlab = null;
		return labHasilBatasSPRepository.findByidlab(idlab);
    }
}