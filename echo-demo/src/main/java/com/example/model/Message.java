package com.example.model;

public class Message {
    private String turbineName;
    private Integer prod;
    private Long time;

    public Message() {
    }

    public Message(String turbineName,Integer prod, Long time) {
        this.turbineName = turbineName;
        this.prod = prod;
        this.time = time;
    }

    public Integer getProd() {
        return prod;
    }

    public void setProd(Integer prod) {
        this.prod = prod;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
