package com.ResumeMatcher.space.payload.request;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class SignupRequest {

	public SignupRequest() {
		super();
	}

	@NotBlank
	@Size(min = 3, max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	private String phone;
	private LocalDate dateOfBirth;
	@Column(name = "role", nullable = true)

	 private Set<String> role;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	  public Set<String> getRole() { return this.role; }
	 
	  public void setRole(Set<String> role) { this.role = role; }
}