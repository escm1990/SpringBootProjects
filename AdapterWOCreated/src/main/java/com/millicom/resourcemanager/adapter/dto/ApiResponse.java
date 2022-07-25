package com.millicom.resourcemanager.adapter.dto;

import java.io.Serializable;

public class ApiResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Boolean success;
	private String message;
	private Object data;

	public ApiResponse(){
	}

	public ApiResponse(Boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public ApiResponse(Boolean success) {
		this.success = success;
	}

	public ApiResponse(String message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
