package com.dev.generik.models.Resep;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dev.generik.entities.ERM.Resep.ContensTabTemplate;
import com.dev.generik.entities.ERM.Resep.ObAtRspTemplate;
import com.dev.generik.models.Metadata;
import com.dev.generik.models.ResponseX;

public class RespErResepOLTemplate {
	 // Static method to build error response
    public static ResponseEntity<ResponseX<ResepOLTemplateResponseModel, Metadata>> ErResp(String errorMsg, ResepOLTemplateModel resepOLModel) {
        // Fill response model with current data or empty data
    	ResepOLTemplateResponseModel errorResponse = new ResepOLTemplateResponseModel();
        errorResponse.setId(resepOLModel.getId());
        errorResponse.setIdDokter(resepOLModel.getIdDokter());
        errorResponse.setNama(resepOLModel.getNama());
        errorResponse.setApproved(resepOLModel.getApproved());
        errorResponse.setRacikan(resepOLModel.getRacikan());
      
        // Convert ObAtRspModel to ObAtRsp and include obatList in error response
        List<ObAtRspTemplate> obatList = resepOLModel.getObatList().stream().map(dto -> {
            ObAtRspTemplate detail = new ObAtRspTemplate();
            detail.setKode(dto.getKode());
            detail.setQty(dto.getQty());
            detail.setSigna(dto.getSigna());
            
            // Proses racikanList
            List<ContensTabTemplate> racikanList = dto.getRacikanList() == null ? Collections.emptyList() : dto.getRacikanList().stream()
                    .map(subDTO -> {
                        ContensTabTemplate subDetail = new ContensTabTemplate();
                        subDetail.setMfdtd(subDTO.getMfdtd());
                        subDetail.setKode(subDTO.getKode());
                        subDetail.setQty(subDTO.getQty());
                        subDetail.setRasio(subDTO.getRasio());
                        return subDetail;
                    })
                    .collect(Collectors.toList());

            detail.setRacikanList(racikanList); // Set racikanList ke ObAtRsp
            return detail;
        }).collect(Collectors.toList());
       
        errorResponse.setObatList(obatList);
  
        // Fill metadata with error status and message
        Metadata errorMetadata = new Metadata(HttpStatus.UNPROCESSABLE_ENTITY.value(), errorMsg);

        // Wrap error details in ResponseX
        ResponseX<ResepOLTemplateResponseModel, Metadata> errorResponseX = new ResponseX<>(errorResponse, errorMetadata);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponseX);
    }

} 
