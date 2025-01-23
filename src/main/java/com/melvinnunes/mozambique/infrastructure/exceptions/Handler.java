package com.melvinnunes.mozambique.infrastructure.exceptions;

import com.melvinnunes.mozambique.interfaces.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Handler {

    @ExceptionHandler(ContentNotFound.class)
    public ResponseEntity<ApiResponse<Void>> handleBodyIsMissingException(HttpServletRequest request, ContentNotFound ex) {
        ApiResponse<Void> response = new ApiResponse<>(ex.getMessage(),  null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
