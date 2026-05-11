package com.dev.generik.service.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Billing.RekLaborat;
import com.dev.generik.repository.ERM.Billing.RekLaboratRepository;
import java.util.List;

@Service
public class RekLaboratService {
    @Autowired
    private RekLaboratRepository rekLaboratRepository;

    public List<RekLaborat> getByidreg(Long idreg) {
       // Long IDlab = null;
		return rekLaboratRepository.findByid(idreg);
    }
}