package com.nettrack.user.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserBean {

	private Long userID;
	
	@NotNull(message = "firstname is mandatory")
	@NotBlank(message = "firstname is mandatory")
	@Size(min=2, message = "{firstname should contain atleast 2 characters}")
	private String firstName;
	
	@NotNull(message = "firstname is mandatory")
	@NotBlank(message = "lastname is mandatory")
	@Size(min=2, message = "{lastname should contain atleast 2 characters}")
	private String lastName;

	@Email
	@NotBlank(message = "email is mandatory")
	@NotNull(message = "email is mandatory")
	private String email;
	
	@NotBlank(message = "password is mandatory")
	@NotNull(message = "password is mandatory")
	@Size(min=8,max=20, message = "{password should be between 8 and 20 characters}")
	private String password;
	
	@NotBlank(message = "contactno is mandatory")
	@NotNull(message = "contactno is mandatory")
	@Size(min=8,max=20, message = "{password should be between 8 and 20 characters}")
	private String contactNo;
	
	/**
	 * 0 - Disable
	 * 1 - Logged out
	 * 2 - Logged In
	 */
	private int userType;
	
	public UserBean() {
		super();
	}

	public UserBean(Long userID,
			@NotNull(message = "firstname is mandatory") @NotBlank(message = "firstname is mandatory") @Size(min = 2, message = "{firstname should contain atleast 2 characters}") String firstName,
			@NotNull(message = "firstname is mandatory") @NotBlank(message = "lastname is mandatory") @Size(min = 2, message = "{lastname should contain atleast 2 characters}") String lastName,
			@Email @NotBlank(message = "email is mandatory") @NotNull(message = "email is mandatory") String email,
			@NotBlank(message = "password is mandatory") @NotNull(message = "password is mandatory") @Size(min = 8, max = 20, message = "{password should be between 8 and 20 characters}") String password,
			@NotBlank(message = "contactno is mandatory") @NotNull(message = "contactno is mandatory") @Size(min = 8, max = 20, message = "{password should be between 8 and 20 characters}") String contactNo,
			int userType) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.userType = userType;
	}
	
	
	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "User [userID =" + userID+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", contactNo=" + contactNo + ", userType=" + userType + "]";
	}
	
		
}
