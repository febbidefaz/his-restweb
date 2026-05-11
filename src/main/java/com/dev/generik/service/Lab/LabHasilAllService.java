package com.dev.generik.service.Lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.Lab.LabHasilAll;
import com.dev.generik.repository.ERM.Lab.LabHasilAllRepository;
import java.util.List;

@Service
public class LabHasilAllService {
    @Autowired
    private LabHasilAllRepository labHasilAllRepository;

    public List<LabHasilAll> getByidreg(Long idreg) {
       // Long IDlab = null;
		return labHasilAllRepository.findByIdreg(idreg);
    }
}