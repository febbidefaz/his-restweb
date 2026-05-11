package com.dev.generik.service.RJ.Operasi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.RJ.Operasi.Operasi;
import com.dev.generik.repository.RJ.Operasi.OperasiRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperasiService {
    @Autowired
    private OperasiRepository operasiRepository;

    public List<Operasi> getTop20() {
        return operasiRepository.findTop20().stream()
                .limit(20)
                .collect(Collectors.toList());
    }
    
    public List<Operasi> findByNamaContains(String keyword) {
        List<Operasi> all = operasiRepository.findTop20();
        if (keyword != null && !keyword.isEmpty()) {
            return all.stream()
                    .filter(op -> op.getNama() != null && op.getNama().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return all;
    }
    
    public Optional<Operasi> findById(Long id) {
        return operasiRepository.findById(id);
    }

}