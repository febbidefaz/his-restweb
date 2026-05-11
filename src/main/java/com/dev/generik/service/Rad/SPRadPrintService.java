package com.dev.generik.service.Rad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.generik.entities.ERM.SP.SPRadPrint;
import com.dev.generik.repository.ERM.SP.SPRadPrintRepository;
import java.util.List;

@Service
public class SPRadPrintService {
    @Autowired
    private SPRadPrintRepository sPRadPrintRepository;

    public List<SPRadPrint> getByNo(Long no) {
       // Long IDlab = null;
		return sPRadPrintRepository.findByNo(no);
    }
}