package com.hotelmanagement.user.service.userservice.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExepctionHandler {
    public ResponseEntity<ProblemDetail> handlerNotFoundException(ResourceNotFoundException ex){
       ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
       problemDetail.setDetail(ex.getMessage());
       problemDetail.setStatus(0);
       return new ResponseEntity<>(problemDetail,HttpStatus.NOT_FOUND);

    }
     @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
    } 
}
