package com.dev.generik.service.PA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.PA.PAHasil;
import com.dev.generik.repository.ERM.PA.PAHasilRepository;

import java.util.List;

@Service
public class PAHasilService {
    @Autowired
    private PAHasilRepository pAHasilRepository;

    public List<PAHasil> getBypadoc(String padoc) {
       // Long IDlab = null;
		return pAHasilRepository.findBypadoc(padoc);
    }
}