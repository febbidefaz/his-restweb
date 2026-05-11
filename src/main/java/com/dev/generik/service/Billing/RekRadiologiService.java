package com.dev.generik.service.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Billing.RekRadiologi;
import com.dev.generik.repository.ERM.Billing.RekRadiologiRepository;
import java.util.List;

@Service
public class RekRadiologiService {
    @Autowired
    private RekRadiologiRepository rekRadiologiRepository;

    public List<RekRadiologi> getByidreg(Long idreg) {
       // Long IDlab = null;
		return rekRadiologiRepository.findByid(idreg);
    }
}