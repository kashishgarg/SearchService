package SearchService.exception;

import SearchService.utils.StatusCode;

public class InvalidPrefixException extends RuntimeException{
	
	private int errCode = StatusCode.INVALID_PREFIX_ERROR.getCode();
	private String errMessage = StatusCode.INVALID_PREFIX_ERROR.getMessage();
	
	public InvalidPrefixException() {
		super(StatusCode.INVALID_PREFIX_ERROR.getMessage());
		errCode = StatusCode.INVALID_PREFIX_ERROR.getCode();
		errMessage = StatusCode.INVALID_PREFIX_ERROR.getMessage();
	}
	
	public InvalidPrefixException(int code, String message) {
		this.errCode = code;
		this.errMessage = message;
	}
	
	public int getErrCode() {
		return this.errCode;
	}
	
	public String getMessage() {
		return this.errMessage;
	}
	
	@Override
	public String toString() {
		return "Invalid prefix Exception{" +
				"errCode: " + errCode + ","
				+"errMessage:" + errMessage 
				+ "}";
	}
}
