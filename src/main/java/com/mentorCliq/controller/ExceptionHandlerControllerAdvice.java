package com.mentorCliq.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    private static final String KEY_ERROR = "error";
    private static final String KEY_STATUS = "status";
    private static final String KEY_ERROR_MESSAGE = "errorMessage";

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject(KEY_STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject(KEY_ERROR_MESSAGE, ex.getMessage());
        mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        mav.setViewName(KEY_ERROR);
        return mav;
    }
}