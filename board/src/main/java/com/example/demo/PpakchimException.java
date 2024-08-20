package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "객체 없음")
public class PpakchimException extends Exception {

	public PpakchimException(String msg) {
		super(msg);
	}
	
}
