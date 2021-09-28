package com.java_shop.Response;

import com.google.gson.Gson;

public class Response<T> {
    T data;
    String error = "";

    public Response(T data) {
        this.data = data;
    }

    public Response(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public String getBody() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }
}
