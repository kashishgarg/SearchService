package SearchService.utils;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder
public class ErrorSearchReturn {
	
	  @JsonProperty("request_time")
	  private String requestTime;

	  @JsonProperty("status")
	  private Status status = null;

	public ErrorSearchReturn(Status status, String requestTime) {
		super();
		this.requestTime = requestTime;
		this.status = status;
	}
	public ErrorSearchReturn (int code, String message) {
		super();
		Date requestDate = new Date();
		this.requestTime = requestDate.toString();
		this.status = new Status();
		this.status.setErrorCode(code);
		this.status.setMessage(message);
	}
	  

}
