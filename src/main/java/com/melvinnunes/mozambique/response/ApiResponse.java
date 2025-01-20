package com.melvinnunes.mozambique.response;

public record ApiResponse<T>(
        String message,
        T data
) {
}
