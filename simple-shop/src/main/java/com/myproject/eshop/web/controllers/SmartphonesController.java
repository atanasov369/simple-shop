package com.myproject.eshop.web.controllers;

import com.myproject.eshop.data.entities.Smartphone;
import com.myproject.eshop.data.models.binding.SmartphoneCreateBindingModel;
import com.myproject.eshop.data.models.service.SmartphoneServiceModel;
import com.myproject.eshop.data.models.view.SmartphoneAllViewModel;
import com.myproject.eshop.services.SmartphoneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SmartphonesController extends BaseController {

    private final SmartphoneService smartphoneService;
    private final ModelMapper modelMapper;

    @Autowired
    public SmartphonesController(SmartphoneService smartphoneService, ModelMapper modelMapper) {
        this.smartphoneService = smartphoneService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/smartphones-all")
    public ModelAndView smartphones(ModelAndView modelAndView) {
        List<SmartphoneAllViewModel> smartphones =
                smartphoneService.findAllSmartphones()
                        .stream()
                        .map(smartphone -> modelMapper.map(smartphone, SmartphoneAllViewModel.class))
                        .collect(Collectors.toList());
        modelAndView.addObject("smartphones", smartphones);
        return super.view(modelAndView, "/smartphone/smartphones-all");
    }

    @GetMapping("/smartphones-create")
    public ModelAndView create() {
        return super.view("/smartphone/smartphones-create");
    }

    @PostMapping("/smartphones-create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView createConfirm(@ModelAttribute SmartphoneCreateBindingModel model) {
        smartphoneService.createSmartphone(modelMapper.map(model, SmartphoneServiceModel.class));
        return super.redirect("/smartphones-all");
    }

    @GetMapping("/smartphones/{brand}/{model}")
    public ModelAndView view(@PathVariable("brand") String brand, @PathVariable("model") String model, ModelAndView modelAndView) {
        SmartphoneServiceModel smartphone = smartphoneService.findByBrandAndModel(brand, model);
        modelAndView.addObject("smartphone", smartphone);
        return super.view(modelAndView, "/smartphone/smartphones-single-view");
    }

    @GetMapping("/smartphones-edit/{brand}/{model}")
    public ModelAndView edit(@PathVariable String brand, @PathVariable String model, ModelAndView modelAndView) {
        SmartphoneServiceModel smartphone = smartphoneService.findByBrandAndModel(brand, model);
        modelAndView.addObject("smartphone", smartphone);
        return super.view(modelAndView, "/smartphone/smartphones-edit");
    }

    @PostMapping("/smartphones-edit/{brand}/{model}")
    public ModelAndView editConfirm(@PathVariable String brand, @PathVariable String model, @ModelAttribute SmartphoneCreateBindingModel smartphone) {
        smartphoneService.editSmartphone(brand, model, modelMapper.map(smartphone, SmartphoneServiceModel.class));
        return super.redirect("/smartphones/" + brand + "/" + model);
    }
}
