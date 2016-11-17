package com.rev.model;

public class Message {
    private Integer prod;
    private Long time;

    public Message(Integer prod, Long time) {
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
