package com.ResumeMatcher.space.dto;

import lombok.Data;

@Data
public class RegisterRequest {
	
	
	public RegisterRequest() {
		super();
	}
	private String userName ;
	private String password ;
	private String email ; 
}
