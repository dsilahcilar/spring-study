package com.example.model;

public class Message {
    private String turbineName;
    private Integer prod;
    private Long time;
    private Double sumRevenue;
    private Long sumProd;

    public Message() {
    }

    public Message(String turbineName, Integer prod, Long time, Double sumRevenue, Long sumProd) {
        this.turbineName = turbineName;
        this.prod = prod;
        this.time = time;
        this.sumRevenue = sumRevenue;
        this.sumProd = sumProd;
    }

    public Double getSumRevenue() {
        return sumRevenue;
    }

    public void setSumRevenue(Double sumRevenue) {
        this.sumRevenue = sumRevenue;
    }

    public Long getSumProd() {
        return sumProd;
    }

    public void setSumProd(Long sumProd) {
        this.sumProd = sumProd;
    }

    public String getTurbineName() {
        return turbineName;
    }

    public void setTurbineName(String turbineName) {
        this.turbineName = turbineName;
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
