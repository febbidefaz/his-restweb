package com.dev.generik.service.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.Lab.LabHasilBatasListRM;
import com.dev.generik.repository.ERM.Lab.LabHasilBatasListRMRepository;

import java.util.List;

@Service
public class LabHasilBatasListRMService {
    @Autowired
    private LabHasilBatasListRMRepository labHasilBatasListRMRepository;

    public List<LabHasilBatasListRM> getByrm(String rm) {
       // Long IDlab = null;
		return labHasilBatasListRMRepository.findByrm(rm);
    }
}