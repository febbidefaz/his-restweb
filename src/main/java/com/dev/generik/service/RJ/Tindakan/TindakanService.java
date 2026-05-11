package com.dev.generik.service.RJ.Tindakan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.RJ.Tindakan.Tindakan;
import com.dev.generik.repository.RJ.Tindakan.TindakanRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TindakanService {
    @Autowired
    private TindakanRepository tindakanRepository;

    public List<Tindakan> getTop20() {
        return tindakanRepository.findTop20().stream()
                .limit(20)
                .collect(Collectors.toList());
    }
    
    public List<Tindakan> findByNamaContains(String keyword) {
        List<Tindakan> all = tindakanRepository.findTop20();
        if (keyword != null && !keyword.isEmpty()) {
            return all.stream()
                    .filter(op -> op.getTindak() != null && op.getTindak().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return all;
    }
    
    public Optional<Tindakan> findById(Long id) {
        return tindakanRepository.findById(id);
    }

}