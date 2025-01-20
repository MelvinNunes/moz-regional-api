package com.melvinnunes.mozambique.infrastructure.exceptions;

import com.melvinnunes.mozambique.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Handler {

    @ExceptionHandler(ContentNotFound.class)
    public ApiResponse<Void> handleBodyIsMissingException(HttpServletRequest request, ContentNotFound ex) {
        return new ApiResponse<>(ex.getMessage(),  null);
    }

}
