package com.dev.generik.service.JadOp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.JadOp.JadOpRoom;
import com.dev.generik.repository.ERM.JadOp.JadOpRoomRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JadOpRoomService {
    @Autowired
    private JadOpRoomRepository jadOpRoomRepository;
   
    public List<JadOpRoom> getTop20() {
        return jadOpRoomRepository.findTop20ByOrderByNamaAsc().stream()
                .limit(20)
                .collect(Collectors.toList());
    }
    
    public List<JadOpRoom> findByNamaContains(String keyword) {
        return jadOpRoomRepository.findByNamaContainingIgnoreCaseOrderByNamaAsc(keyword);
    }    
    
    public Optional<JadOpRoom> findById(Long id) {
        return jadOpRoomRepository.findById(id);
    }
}