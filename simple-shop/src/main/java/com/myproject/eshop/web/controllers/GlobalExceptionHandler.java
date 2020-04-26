package com.myproject.eshop.web.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Throwable e) {
        ModelAndView modelAndView = new ModelAndView("error");

        modelAndView.addObject("errorMessage", e.getMessage());

        return modelAndView;
    }
}
