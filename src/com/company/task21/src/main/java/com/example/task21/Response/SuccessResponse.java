package com.example.task21.Response;

public class SuccessResponse<T> extends UserResponse {
    public SuccessResponse(T data, String message) {
        super(data, message, true);
    }
    public SuccessResponse(T data) {
        super(data, "", true);
    }
}
