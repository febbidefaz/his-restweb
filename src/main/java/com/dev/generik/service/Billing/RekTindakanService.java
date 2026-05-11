package com.dev.generik.service.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Billing.RekTindakan;
import com.dev.generik.repository.ERM.Billing.RekTindakanRepository;
import java.util.List;

@Service
public class RekTindakanService {
    @Autowired
    private RekTindakanRepository rekTindakanRepository;

    public List<RekTindakan> getByidreg(Long idreg) {
       // Long IDlab = null;
		return rekTindakanRepository.findByid(idreg);
    }
}