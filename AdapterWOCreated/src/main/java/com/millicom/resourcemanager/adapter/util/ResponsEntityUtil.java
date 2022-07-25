package com.millicom.resourcemanager.adapter.util;

import org.springframework.http.ResponseEntity;

import com.millicom.resourcemanager.adapter.dto.ApiResponse;


public class ResponsEntityUtil {

	public static ResponseEntity<ApiResponse> responseApiOk(String message, Object data, Boolean success){
		ApiResponse response = new ApiResponse(true);
		response.setData(data);
		response.setMessage(message);
		response.setSuccess(success);
		return ResponseEntity.ok().body(response);		
	}
}
