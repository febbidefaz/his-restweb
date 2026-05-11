package com.dev.generik.service.Obat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.Obat.ObatAll;
import com.dev.generik.repository.Obat.ObatAllRepository;
import java.util.List;

@Service
public class ObatAllService {
    @Autowired
    private ObatAllRepository obatAllRepository;

    public List<ObatAll> getByidreg(Long id) {
       // Long IDlab = null;
		return obatAllRepository.findByIdreg(id);
    }
}