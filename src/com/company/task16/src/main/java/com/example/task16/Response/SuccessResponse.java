package com.example.task16.Response;

public class SuccessResponse<T> extends UserResponse {
    public SuccessResponse(T data, String message) {
        super(data, message, true);
    }
    public SuccessResponse(T data) {
        super(data, "", true);
    }
}
