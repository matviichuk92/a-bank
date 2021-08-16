package com.bank.a.result.handler;

public class CodeDictionary {
    public final static ResultDto code000 = new ResultDto("000", "Operation was successful!");
    public final static ResultDto code001 = new ResultDto("400", "Client doesn't exist!");
    public final static ResultDto code003 = new ResultDto("400", "Invalid request params");
}
