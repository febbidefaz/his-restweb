package com.dev.generik.service.PA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.PA.PAHasilListRM;
import com.dev.generik.repository.ERM.PA.PAHasilListRMRepository;

import java.util.List;

@Service
public class PAHasilListRMService {
    @Autowired
    private PAHasilListRMRepository pAHasilListRMRepository;

    public List<PAHasilListRM> getByrm(String rm) {
       // Long IDlab = null;
		return pAHasilListRMRepository.findByrm(rm);
    }
}