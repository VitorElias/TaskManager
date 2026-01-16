package com.TaskManager.TaskManager.Exceptions.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class BussinessRuleException extends RuntimeException {
    public BussinessRuleException(String message) {
        super(message);
    }
}
