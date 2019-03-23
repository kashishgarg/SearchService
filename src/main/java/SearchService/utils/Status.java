package SearchService.utils;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status   {
	  @JsonProperty("errorCode")
	  private Integer errorCode = null;

	  @JsonProperty("message")
	  private String message = null;

	  public Status errorCode(Integer errorCode) {
	    this.errorCode = errorCode;
	    return this;
	  }

	
	  public Integer getErrorCode() {
	    return errorCode;
	  }

	  public void setErrorCode(Integer errorCode) {
	    this.errorCode = errorCode;
	  }

	  public Status message(String message) {
	    this.message = message;
	    return this;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Status status = (Status) o;
	    return Objects.equals(this.errorCode, status.errorCode) &&
	        Objects.equals(this.message, status.message);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(errorCode, message);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Status {\n");
	    
	    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
	    sb.append("    message: ").append(toIndentedString(message)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
	}