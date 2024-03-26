package com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.exceptions;

import com.Globalexceptionhandling.CurdApiGlobalexceptionhandling.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler(value = NoSuchCustomerExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse
    handleException(NoSuchCustomerExistsException ex)
    {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
