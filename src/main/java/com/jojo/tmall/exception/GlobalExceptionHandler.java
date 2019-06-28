package com.jojo.tmall.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    private int httpStatus;
    private String myMessage;

    public GlobalExceptionHandler() {

    }

    public GlobalExceptionHandler(int httpStatus, String myMessage) {
        this.httpStatus = httpStatus;
        this.myMessage = myMessage;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }

//    @ExceptionHandler(value=Exception.class)
//    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        e.printStackTrace();
//        Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
//        if(null!=e.getCause() && constraintViolationException==e.getCause().getClass()){
//            return "违反了约束，多半是外键约束";
//        }
//        return e.getMessage();
//    }
}
