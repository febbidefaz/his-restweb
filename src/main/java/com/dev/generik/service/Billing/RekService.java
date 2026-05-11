package com.dev.generik.service.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Billing.Rek;
import com.dev.generik.repository.ERM.Billing.RekRepository;
import java.util.Optional;

@Service
public class RekService {
    @Autowired
    private RekRepository rekRepository;

    public Optional<Rek> getByidreg(Long idreg) {
       // Long IDlab = null;
		return rekRepository.findById(idreg);
    }
}