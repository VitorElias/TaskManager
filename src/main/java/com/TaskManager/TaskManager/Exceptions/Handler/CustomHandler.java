package com.TaskManager.TaskManager.Exceptions.Handler;

import com.TaskManager.TaskManager.Exceptions.CustomResponseEntity;
import com.TaskManager.TaskManager.Exceptions.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<CustomResponseEntity> ValidationException(ValidationException ex, WebRequest request){

        CustomResponseEntity c = new CustomResponseEntity(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(c);
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<CustomResponseEntity> notFoundExcept(NotFound ex, WebRequest request){

        CustomResponseEntity c = new CustomResponseEntity(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(c);
    }

    @ExceptionHandler(InvalidTaskException.class)
    public ResponseEntity<CustomResponseEntity> InvalidTaskException(InvalidTaskException ex, WebRequest request){

        CustomResponseEntity c = new CustomResponseEntity(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(c);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomResponseEntity> notFoundExcept(HttpMessageNotReadableException ex, WebRequest request){

        CustomResponseEntity c = new CustomResponseEntity(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(c);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<CustomResponseEntity> notFoundExcept(ConflictException ex, WebRequest request){

        CustomResponseEntity c = new CustomResponseEntity(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(c);
    }

    @ExceptionHandler(BussinessRuleException.class)
    public ResponseEntity<CustomResponseEntity> notFoundExcept(BussinessRuleException ex, WebRequest request){

        CustomResponseEntity c = new CustomResponseEntity(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(c);
    }


}
