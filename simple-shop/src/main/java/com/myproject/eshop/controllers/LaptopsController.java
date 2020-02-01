package com.myproject.eshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LaptopsController extends BaseController {

    @GetMapping("/laptops")
    public ModelAndView laptops() {
        return super.view("laptops");
    }
}
