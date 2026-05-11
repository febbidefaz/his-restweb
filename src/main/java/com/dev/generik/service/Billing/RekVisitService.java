package com.dev.generik.service.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Billing.RekVisit;
import com.dev.generik.repository.ERM.Billing.RekVisitRepository;
import java.util.List;


@Service
public class RekVisitService {
    @Autowired
    private RekVisitRepository rekVisitRepository;

    public List<RekVisit> getByidreg(Long idreg) {
       // Long IDlab = null;
		return rekVisitRepository.findByid(idreg);
    }
}