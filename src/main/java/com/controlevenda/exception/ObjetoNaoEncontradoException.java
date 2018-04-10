package com.controlevenda.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ObjetoNaoEncontradoException extends RuntimeException implements Serializable{
	
	 public ObjetoNaoEncontradoException(String message) {
	        super(message);
	 }

	private static final long serialVersionUID = 2393436785222694613L;
    

}
