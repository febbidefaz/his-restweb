package com.dev.generik.exception;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dev.generik.models.ExLogModel;
import com.dev.generik.models.Metadata;
import com.dev.generik.models.ResponseS;
import com.dev.generik.models.ResponseX;

@ControllerAdvice
public class TrowableExHandler extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ExLogModel<Metadata>> handleException(CustomException e) {
		ExLogModel<Metadata> exLogModel = new ExLogModel<>(new Metadata(e.getCode(), e.getMsg()));
		return new ResponseEntity<>(exLogModel, e.getHttpStatus());
	}
	
	@ResponseBody
	@ExceptionHandler(CustomExceptionS.class)
	public ResponseEntity<Metadata> handleException(CustomExceptionS e) {
		Metadata exLogModel = new Metadata(e.getCode(), e.getMsg());
		return new ResponseEntity<>(exLogModel, e.getHttpStatus());
	}
	
	@ResponseBody
	@ExceptionHandler(CustomExceptionR.class)
	public ResponseEntity<ResponseX<ResponseS, Metadata>> handleException(CustomExceptionR e) {
	    // Bangun metadata untuk error
	    Metadata metadata = new Metadata(e.getCode(), e.getMsg());

	    // Bangun respons dengan response = null
	    ResponseX<ResponseS, Metadata> exLogModel = new ResponseX<>(null, metadata);

	    // Kembalikan ResponseEntity dengan status yang sesuai
	    return new ResponseEntity<>(exLogModel, e.getHttpStatus());
	} 
	
	@ExceptionHandler(CustomExceptionArray.class)
    public ResponseEntity<ResponseX<List<Object>, Metadata>> handleCustomException(CustomExceptionArray e) {
        // Set response sebagai array kosong
        List<Object> emptyResponse = Collections.emptyList();

        // Metadata untuk error
        Metadata metadata = new Metadata(e.getCode(), e.getMsg());

        // Buat respons
        ResponseX<List<Object>, Metadata> response = new ResponseX<>(emptyResponse, metadata);

        return ResponseEntity.status(e.getHttpStatus()).body(response);
    }

	
/*	@ResponseBody
	@ExceptionHandler(CustomExceptionR.class)
	public ResponseEntity<Object> handleException(CustomExceptionR e) {
	//	Metadata exLogModel = new Metadata(e.getCode(), e.getMsg());
		 // Struktur metadata untuk general exception
        Metadata metadata = new Metadata(500, "Internal Server Error: " + e.getMessage());
     // Respons JSON
     //   ResponseX<Object, Metadata> response = new ResponseX<>(null, metadata);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	} */
	
	/*@ResponseBody
	@ExceptionHandler(CustomExceptionR.class)
	public ResponseEntity<ResponseX<ResponseS, Metadata>> handleException(CustomExceptionR e) {
		ResponseX<ResponseS,Metadata> exLogModel = new ResponseS<>(new ResponseS(), new Metadata(e.getCode(), e.getMsg()));
		return new ResponseEntity<>(exLogModel, e.getHttpStatus());
	}*/
	
	/*@ResponseBody
	@ExceptionHandler(CustomExceptionR.class)
	public ResponseEntity<ResponseX<ResponseS, Metadata>> handleException(CustomExceptionR e) {
		ResponseX<ResponseS,Metadata> exLogModel = new ResponseS<>(new ResponseS(), new Metadata(e.getCode(), e.getMsg()));
		return new ResponseEntity<>(exLogModel, e.getHttpStatus());
	}*/
	//}
	
	/*
	 * @Override protected ResponseEntity<Object> handleHttpMessageNotReadable(
	 * HttpMessageNotReadableException e, HttpHeaders headers, HttpStatus status,
	 * WebRequest request) {
	 * 
	 * Metadata metadata = new Metadata(HttpStatus.BAD_REQUEST.value() ,
	 * "Parse Value/Type/Pattern data Invalid ..."); ExLogModel<Metadata> exLogModel
	 * = new ExLogModel<>(metadata); return new ResponseEntity<>(exLogModel,
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException nve, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) {
	 * 
	 * Map<String, String> msg = new LinkedHashMap<>(); msg.put("jenisreferensi",
	 * "Jenis Referensi Harus Diisi 1 atau 2 ..." ); msg.put("jenisrequest",
	 * "Jenis Request Harus Diisi 1 atau 2 ..." ); msg.put("polieksekutif",
	 * "Poli Harus Diisi 0 atau 1 ..."); msg.put("nomorkartu",
	 * "Nomer Peserta harus 13 digit ..."); msg.put("tanggalperiksa",
	 * "Tanggal Periksa/Daftar Pasien Expired ..."); msg.put("tanggalawal",
	 * "Tanggal Awal Expire..."); msg.put("tanggalakhir",
	 * "Tanggal Akhir Expire..."); msg.put("kodepoli", "Kode Poli Tidak Valid...");
	 * 
	 * Metadata metadata = new Metadata(HttpStatus.BAD_REQUEST.value() ,
	 * msg.get(nve.getBindingResult().getFieldError().getField()));
	 * ExLogModel<Metadata> exLogModel = new ExLogModel<>(metadata); return new
	 * ResponseEntity<>(exLogModel, HttpStatus.BAD_REQUEST);
	 * 
	 * 
	 * Map<String, Object> body = new LinkedHashMap<>(); // body.put("timestamp",
	 * LocalDateTime.now());
	 * 
	 * // body.put("code", status.value());
	 * 
	 * //Get all errors List<Metadata> errors = nve.getBindingResult()
	 * .getFieldErrors() .stream() .map(e-> new
	 * Metadata(HttpStatus.BAD_REQUEST.value(), msg.get(e.getField())))
	 * .collect(Collectors.toList());
	 * 
	 * body.put("metadata", errors);
	 * 
	 * return new ResponseEntity<>(body, headers, status);
	 * 
	 * }
	 */
}
