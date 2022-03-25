package com.example.task21.Response;

public class ErrorResponse extends UserResponse {
    public ErrorResponse(String message) {
        super(null, message, false);
    }
}
