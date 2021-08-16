package com.bank.a.result.handler;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import static com.bank.a.result.handler.CodeDictionary.code003;

@ControllerAdvice
public class ExceptionHandlerController {
    @Autowired
    private Gson gson;

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String showCustomException(Exception e) {
        e.printStackTrace();
        return gson.toJson(code003);
    }
}