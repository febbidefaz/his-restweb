package com.dev.generik.service.Rad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Rad.RadHasilAll;
import com.dev.generik.repository.ERM.Rad.RadHasilAllRepository;
import java.util.List;

@Service
public class RadHasilAllService {
    @Autowired
    private RadHasilAllRepository radHasilAllRepository;

    public List<RadHasilAll> getByidreg(Long idreg) {
       // Long IDlab = null;
		return radHasilAllRepository.findByIdreg(idreg);
    }
}