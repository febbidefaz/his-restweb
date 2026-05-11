package com.dev.generik.service.Dokter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.Dokter.DokterOp;
import com.dev.generik.repository.Dokter.DokterOpRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DokterOpService {
    @Autowired
    private DokterOpRepository dokterOpRepository;

    public List<DokterOp> getTop20() {
        return dokterOpRepository.findTop20ByOrderByDokterAsc().stream()
                .limit(20)
                .collect(Collectors.toList());
    }    
    
    public Optional<DokterOp> findById(Long id) {
        return dokterOpRepository.findById(id);
    }
    
    public List<DokterOp> findByNamaContains(String keyword) {
        return dokterOpRepository.findTop20ByDokterContainingIgnoreCaseOrderByDokterAsc(keyword);
    }
    
    public List<DokterOp> findByNamaOpContains(String keywordOp) {
        return dokterOpRepository.findTop20ByDokterOpContainingIgnoreCaseOrderByDokterAsc(keywordOp);
    }
    
    public Optional<DokterOp> findByKdBPJS(String kdBPJS) {
        return dokterOpRepository.findByKdBPJSIgnoreCase(kdBPJS);
    }

}