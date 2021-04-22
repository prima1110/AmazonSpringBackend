package com.example.AmazonMini;
import java.util.List;

public class DataResponse<T>{

    private List<T> body;
    private String message;


    public DataResponse(List<T> body, String message) {
        this.body = body;
        this.message = message;
    }

    public DataResponse() {
    }

    public List<T> getBody() {
        return body;
    }

    public void setBody(List<T> body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
