package com.nettrack.user.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nettrack.user.exception.CustomAPIResponse;

public class LoginBean {

	@Email
	@NotBlank(message = "email is mandatory")
	@NotNull(message = "email is mandatory")
	private String email;
	
	@NotBlank(message = "password is mandatory")
	@NotNull(message = "password is mandatory")
	@Size(min=8,max=20, message = "{password should be between 8 and 20 characters}")
	private String password;

	private CustomAPIResponse response;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomAPIResponse getResponse() {
		return response;
	}

	public void setResponse(CustomAPIResponse response) {
		this.response = response;
	}

	public LoginBean(
			@Email @NotBlank(message = "email is mandatory") @NotNull(message = "email is mandatory") String email,
			@NotBlank(message = "password is mandatory") @NotNull(message = "password is mandatory") @Size(min = 8, max = 20, message = "{password should be between 8 and 20 characters}") String password,
			CustomAPIResponse response) {
		super();
		this.email = email;
		this.password = password;
		this.response = response;
	}

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
