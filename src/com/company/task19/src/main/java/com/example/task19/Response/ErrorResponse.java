package com.example.task19.Response;

public class ErrorResponse extends UserResponse {
    public ErrorResponse(String message) {
        super(null, message, false);
    }
}
