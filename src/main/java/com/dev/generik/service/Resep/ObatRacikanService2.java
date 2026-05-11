package com.dev.generik.service.Resep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.Resep.Obat;
import com.dev.generik.repository.Resep.ObatRacikanRepository;
//import java.util.List;
import java.util.Optional;

@Service
public class ObatRacikanService2 {
    @Autowired
    private ObatRacikanRepository obatRacikanRepository;

  /*  public List<Obat> getAll() {
		return obatRacikanRepository.getAll();
    } */
    
    public Optional<Obat> getObatByKode(String kode) {
        return obatRacikanRepository.findByKode(kode);
    }    

    
  }