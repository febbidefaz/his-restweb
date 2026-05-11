package com.dev.generik.service.Resep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.Resep.Obat;
import com.dev.generik.repository.Resep.ObatRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ObatService2 {
    @Autowired
    private ObatRepository obatRepository;

    public List<Obat> getAll() {
		return obatRepository.findAll();
    }
    
    public Optional<Obat> getObatByKode(String kode) {
        return obatRepository.findByKode(kode);
    }    

    
  }