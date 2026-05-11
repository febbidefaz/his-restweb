package com.dev.generik.service.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Billing.RekLain;
import com.dev.generik.repository.ERM.Billing.RekLainRepository;
import java.util.List;

@Service
public class RekLainService {
    @Autowired
    private RekLainRepository rekLainRepository;

    public List<RekLain> getByidreg(Long idreg) {
       // Long IDlab = null;
		return rekLainRepository.findByid(idreg);
    }
}