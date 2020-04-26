package com.jagan.exception;
import com.jagan.response.ApiResponse;
import io.micronaut.http.annotation.Error;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;


public class GlobalExceptionHandler {

    @Error(exception = ConstraintViolationException.class, global = true)
    public ApiResponse onFailure(ConstraintViolationException ex) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(400);
        Set<ConstraintViolation<?>> constraintViolationExceptionSet =
                ex.getConstraintViolations();

        List<String> messages = new ArrayList<>();

        for (ConstraintViolation<?> constraintViolation : constraintViolationExceptionSet) {
            messages.add(constraintViolation.getMessage());
        }
        apiResponse.setMessage(messages);
        return apiResponse;
    }


}
