package com.melvinnunes.mozambique.interfaces.response;

public record ApiResponse<T>(
        String message,
        T data
) {
}
