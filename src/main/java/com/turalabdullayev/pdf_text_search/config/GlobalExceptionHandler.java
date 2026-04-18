package com.turalabdullayev.pdf_text_search.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<String> handleMaxSizeException(MaxUploadSizeExceededException exc) {
		return ResponseEntity.badRequest().body("Faylin olcusu cox boyukdur (Max: 50MB)");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception exc) {
		return ResponseEntity.status(500).body("Sistemde xeta bas verdi: " + exc.getMessage());

	}

}
