package com.dev.generik.service.PPRA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.PPRA.ObatPPRA;
import com.dev.generik.repository.ERM.PPRA.ObatPPRARepository;
import java.util.List;

@Service
public class ObatPPRAService {
    @Autowired
    private ObatPPRARepository obatPPRARepository;

    public List<ObatPPRA> getById(Long idreg) {
       // Long IDlab = null;
		return obatPPRARepository.findByid(idreg);
    }
}