package com.bank.a.result.handler;

public class ResultDto {
    private String error;
    private String text;

    public ResultDto() {
    }

    public ResultDto(String error, String text) {
        this.error = error;
        this.text = text;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
