package com.example.practica03.controllers.dtos.requests;

public class CreateCommentRequest {
    private String name;
    private  String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}