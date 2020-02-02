package com.myproject.eshop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralQuestionsController extends BaseController {

    @GetMapping("/general-questions")
    public ModelAndView generalQuestions() {
        return super.view("general-questions");
    }
}
