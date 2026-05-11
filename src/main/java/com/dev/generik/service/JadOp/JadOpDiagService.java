package com.dev.generik.service.JadOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.generik.entities.ERM.JadOp.JadOpDiag;
import com.dev.generik.repository.ERM.JadOp.JadOpDiagRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JadOpDiagService {
    @Autowired
    private JadOpDiagRepository jadOpDiagRepository;

    public List<JadOpDiag> getTop20() {
        return jadOpDiagRepository.findTop20ByOrderByNamaAsc().stream()
                .limit(20)
                .collect(Collectors.toList());
    }
    
    public List<JadOpDiag> findByNamaContains(String keyword) {
        return jadOpDiagRepository.findByNamaContainingIgnoreCaseOrderByNamaAsc(keyword);
    }  
    
    public List<JadOpDiag> findByInitialContains(String initial) {
        return jadOpDiagRepository.findByInitialContainingIgnoreCaseOrderByInitialAsc(initial);
    }
    
    public Optional<JadOpDiag> findById(Long id) {
        return jadOpDiagRepository.findById(id);
    }
}