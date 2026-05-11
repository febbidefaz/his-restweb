package com.dev.generik.exception;

//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import java.util.LinkedHashMap;
//import java.util.Map;
import com.dev.generik.models.Metadata;

@ControllerAdvice
public class TrowableExHandlerNew extends ResponseEntityExceptionHandler {

	/*@ResponseBody
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ExLogModel<Metadata>> handleException(CustomException e) {
		ExLogModel<Metadata> exLogModel = new ExLogModel<>(new Metadata(e.getCode(), e.getMsg()));
		return new ResponseEntity<>(exLogModel, e.getHttpStatus());
	} */
	
	@ResponseBody
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Metadata> handleException(CustomException e) {
		Metadata exLogModel = new Metadata(e.getCode(), e.getMsg());
		return new ResponseEntity<>(exLogModel, e.getHttpStatus());
	}
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
