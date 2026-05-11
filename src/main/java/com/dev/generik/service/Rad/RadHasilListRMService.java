package com.dev.generik.service.Rad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.Rad.RadHasilListRM;
import com.dev.generik.repository.ERM.Rad.RadHasilListRMRepository;

import java.util.List;

@Service
public class RadHasilListRMService {
    @Autowired
    private RadHasilListRMRepository radHasilListRMRepository;

    public List<RadHasilListRM> getByrm(String rm) {
       // Long IDlab = null;
		return radHasilListRMRepository.findByrm(rm);
    }
}