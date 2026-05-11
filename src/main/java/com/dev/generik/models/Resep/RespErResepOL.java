package com.dev.generik.models.Resep;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dev.generik.entities.ERM.Resep.ContensTab;
import com.dev.generik.entities.ERM.Resep.ObAtRsp;
import com.dev.generik.models.Metadata;
import com.dev.generik.models.ResponseX;

public class RespErResepOL {
	 // Static method to build error response
    public static ResponseEntity<ResponseX<ResepOLResponseModel, Metadata>> ErResp(String errorMsg, ResepOLModel resepOLModel) {
        // Fill response model with current data or empty data
        ResepOLResponseModel errorResponse = new ResepOLResponseModel();
        errorResponse.setIdReg(resepOLModel.getIdReg());
        errorResponse.setTgl(resepOLModel.getTgl());
        errorResponse.setJam(resepOLModel.getJam());
        errorResponse.setIdDokter(resepOLModel.getIdDokter());
        errorResponse.setKelasID(resepOLModel.getKelasID());
        errorResponse.setRoomID(resepOLModel.getRoomID());
        errorResponse.setManual(resepOLModel.getManual());

        // Convert ObAtRspModel to ObAtRsp and include obatList in error response
        List<ObAtRsp> obatList = resepOLModel.getObatList().stream().map(dto -> {
            ObAtRsp detail = new ObAtRsp();
            detail.setKode(dto.getKode());
            detail.setQty(dto.getQty());
            detail.setSigna(dto.getSigna());
            
            // Proses racikanList
            List<ContensTab> racikanList = dto.getRacikanList() == null ? Collections.emptyList() : dto.getRacikanList().stream()
                    .map(subDTO -> {
                        ContensTab subDetail = new ContensTab();
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
        ResponseX<ResepOLResponseModel, Metadata> errorResponseX = new ResponseX<>(errorResponse, errorMetadata);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponseX);
    }

} 
