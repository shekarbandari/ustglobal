package com.ust.pms.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserRegistration {
	@NotBlank(message = "user name is mandatory")
	private String username;

	@NotBlank(message = "new password is mandatory")
	private String password;

	@NotBlank(message = "confirm password is mandatory")
	private String confirmPassword;
	
	@NotBlank(message = "role is mandatory")
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
