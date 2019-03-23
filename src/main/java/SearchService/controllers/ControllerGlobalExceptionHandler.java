package SearchService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import SearchService.exception.InvalidPrefixException;
import SearchService.utils.ErrorSearchReturn;

@ControllerAdvice
public class ControllerGlobalExceptionHandler {

	@ExceptionHandler(InvalidPrefixException.class)
	public ResponseEntity<ErrorSearchReturn> handleInvalidPrefixException(InvalidPrefixException e) {
		 return new ResponseEntity<>(new ErrorSearchReturn(e.getErrCode(),
				 e.getMessage()), HttpStatus.UNAUTHORIZED);
	}
}
