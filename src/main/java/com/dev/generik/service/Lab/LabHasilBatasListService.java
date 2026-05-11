package com.dev.generik.service.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.Lab.LabHasilBatasList;
import com.dev.generik.repository.ERM.Lab.LabHasilBatasListRepository;

import java.util.List;

@Service
public class LabHasilBatasListService {
    @Autowired
    private LabHasilBatasListRepository labHasilBatasListRepository;

    public List<LabHasilBatasList> getByidreg(Long idreg) {
       // Long IDlab = null;
		return labHasilBatasListRepository.findByidreg(idreg);
    }
}