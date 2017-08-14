package com.example.demo2.model;

import org.springframework.http.HttpStatus;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 */
public class Response<T> {

    private int status;
    private HttpStatus message;
    private T data;

    public Response() {

    }

    public Response(HttpStatus message) {
        this(message, null);
    }

    public Response(HttpStatus message, T data) {
        this.status = message.value();
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HttpStatus getMessage() {
        return message;
    }

    public void setMessage(HttpStatus message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
