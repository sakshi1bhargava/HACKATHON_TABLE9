package com.dbs.model;

public class ErrorResponse {
	
	
private Integer errorcode;
private String errorMessage;
public Integer getErrorcode() {
	return errorcode;
}
public void setErrorcode(Integer i) {
	this.errorcode = i;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
@Override
public String toString() {
	return "ErrorResponse [errorcode=" + errorcode + ", errorMessage=" + errorMessage + "]";
}

}
