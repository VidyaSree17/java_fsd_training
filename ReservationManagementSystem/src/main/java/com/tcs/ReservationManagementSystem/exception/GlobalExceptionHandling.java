package com.tcs.ReservationManagementSystem.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>handleBeanObject(MethodArgumentNotValidException me){
		BindingResult br=me.getBindingResult();
		Map<String,String> map=new HashMap<>();
		br.getFieldErrors().forEach(x->map.put(x.getField(), x.getDefaultMessage()));
		return new ResponseEntity<>(map,HttpStatus.PARTIAL_CONTENT);
		
		
	}
}
