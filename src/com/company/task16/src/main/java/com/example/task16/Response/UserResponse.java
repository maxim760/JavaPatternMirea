package com.example.task16.Response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class UserResponse<T> {
    private String message;
    private T data;
    private boolean result;
    public UserResponse(T data, String message, boolean result) {
        this.data = data;
        this.message = message;
        this.result = result;
    }

}
