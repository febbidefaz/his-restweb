package com.dev.generik.service.Lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.SP.SPLabPrint;
import com.dev.generik.repository.ERM.SP.SPLabPrintRepository;
import java.util.List;

@Service
public class SPLabPrintService {
    @Autowired
    private SPLabPrintRepository sPLabPrintRepository;

    public List<SPLabPrint> getByNo(Long no) {
       // Long IDlab = null;
		return sPLabPrintRepository.findByNo(no);
    }
}