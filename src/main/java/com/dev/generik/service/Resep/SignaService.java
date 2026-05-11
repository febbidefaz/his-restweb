package com.dev.generik.service.Resep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.Resep.Signa;
import com.dev.generik.repository.Resep.SignaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SignaService {
    @Autowired
    private SignaRepository signaRepository;

    public List<Signa> getAll() {
       // Long IDlab = null;
		return signaRepository.getAll();
    }
    
    public Optional<Signa> getById(Long id) {
        return signaRepository.getAll().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }
    
    public List<Signa> getTop20() {
        return signaRepository.getAll().stream()
                .limit(20)
                .collect(Collectors.toList());
    }

    public List<Signa> searchBySigna(String keyword) {
        return signaRepository.getAll().stream()
                .filter(s -> s.getSigna() != null && s.getSigna().toLowerCase().contains(keyword.toLowerCase()))
                .limit(20)
                .collect(Collectors.toList());
    }
    
}