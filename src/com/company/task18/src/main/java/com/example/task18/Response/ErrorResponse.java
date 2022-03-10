package com.example.task18.Response;

public class ErrorResponse extends UserResponse {
    public ErrorResponse(String message) {
        super(null, message, false);
    }
}
