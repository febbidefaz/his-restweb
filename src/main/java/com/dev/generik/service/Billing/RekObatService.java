package com.dev.generik.service.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Billing.RekObat;
import com.dev.generik.repository.ERM.Billing.RekObatRepository;

import java.util.List;

@Service
public class RekObatService {
    @Autowired
    private RekObatRepository rekObatRepository;

    public List<RekObat> getByidreg(Long idreg) {
       // Long IDlab = null;
		return rekObatRepository.findByid(idreg);
    }
}