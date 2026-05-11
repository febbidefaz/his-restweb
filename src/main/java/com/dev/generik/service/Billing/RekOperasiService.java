package com.dev.generik.service.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Billing.RekOperasi;
import com.dev.generik.repository.ERM.Billing.RekOperasiRepository;

import java.util.List;

@Service
public class RekOperasiService {
    @Autowired
    private RekOperasiRepository rekOperasiRepository;

    public List<RekOperasi> getByidreg(Long idreg) {
       // Long IDlab = null;
		return rekOperasiRepository.findByid(idreg);
    }
}