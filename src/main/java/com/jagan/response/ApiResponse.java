package com.jagan.response;


import java.util.List;

public class ApiResponse {

    private int code;
    private List<String> message;

    public void setCode(int code) {
         this.code = code;
    }

    public int getCode() {
        return code;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
