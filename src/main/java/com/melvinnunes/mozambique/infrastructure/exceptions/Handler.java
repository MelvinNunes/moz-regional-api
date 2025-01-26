package com.melvinnunes.mozambique.infrastructure.exceptions;

import com.melvinnunes.mozambique.interfaces.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Handler {

    @ExceptionHandler(ContentNotFound.class)
    public ResponseEntity<ApiResponse<Void>> handleContentNotFoundException(HttpServletRequest request, ContentNotFound ex) {
        ApiResponse<Void> response = new ApiResponse<>(ex.getMessage(),  null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Void>> handleBadRequestException(HttpServletRequest request, BadRequestException ex) {
        ApiResponse<Void> response = new ApiResponse<>(ex.getMessage(),  null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNoHandlerFoundException(HttpServletRequest request,NoHandlerFoundException ex) {
        ApiResponse<Void> response = new ApiResponse<>("Route not found!",  null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
