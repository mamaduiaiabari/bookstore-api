package com.demo.resource.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.File;

public class ValidationError extends StandardError {
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(long l, int i, String string) {
		super(l, i, string);
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
	
	
}
