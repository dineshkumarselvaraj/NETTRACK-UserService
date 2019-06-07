package com.nettrack.user.exception;

public class CustomAPIResponse {

	private String errorcode;
	
	private String errormessage;

	public CustomAPIResponse(String errorcode, String errormessage) {
		super();
		this.errorcode = errorcode;
		this.errormessage = errormessage;
	}
	
	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public CustomAPIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
