package com.dev.generik.service.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.Lab.LabHasilKultur;
import com.dev.generik.repository.ERM.Lab.LabHasilKulturRepository;

import java.util.List;

@Service
public class LabHasilKulturService {
    @Autowired
    private LabHasilKulturRepository labHasilKulturRepository;

    public List<LabHasilKultur> getByidreg(Long idreg) {
       // Long IDlab = null;
		return labHasilKulturRepository.findByidreg(idreg);
    }
}