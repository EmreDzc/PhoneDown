package com.example.phonedown.util;

public interface DataCallback<T> {
    void onSuccess(T data);
    void onError(String error);
}
