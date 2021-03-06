package com.myproject.eshop.services;

import com.myproject.eshop.data.models.service.LaptopServiceModel;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

public interface LaptopService {

    List<LaptopServiceModel> findAllLaptops();

    LaptopServiceModel createLaptop(LaptopServiceModel laptopServiceModel, Principal principal);

    LaptopServiceModel findByBrandAndModel(String brand, String model);

    LaptopServiceModel editLaptop(String brand, String model, LaptopServiceModel laptopServiceModel, Principal principal);

    void deleteLaptop(String brand, String model, Principal principal);

    List<LaptopServiceModel> findByBrand(String brand);

    void addLaptopToCart(HttpSession httpSession, String brand, String model);
}
