package SearchService.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public enum StatusCode {
	
	INVALID_PREFIX_ERROR(501, "There is no word with the given prefix.");
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	private int code;
	
	private StatusCode(int code, String message) {
		this.message = message;
		this.code = code;
	}
}
