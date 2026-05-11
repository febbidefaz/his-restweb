package com.dev.generik.service.Rad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.Rad.RadHasilList;
import com.dev.generik.repository.ERM.Rad.RadHasilListRepository;

import java.util.List;

@Service
public class RadHasilListService {
    @Autowired
    private RadHasilListRepository radHasilListRepository;

    public List<RadHasilList> getByidreg(Long idreg) {
       // Long IDlab = null;
		return radHasilListRepository.findByidreg(idreg);
    }
}