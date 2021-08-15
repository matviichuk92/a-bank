package com.bank.a.result.handler;

public class ResultDto {
    private String code;
    private String text;
    private Object data;

    public ResultDto() {
    }

    public ResultDto(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultDto addData(Object data) {
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
