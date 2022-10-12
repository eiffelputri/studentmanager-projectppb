package com.example.siswa.database;

public interface QueryResponse<T> {
    void onSuccess(T data);
    void onFailure(String message);
}