package com.myproject.eshop.repositories;

import com.myproject.eshop.data.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, String> {

    Optional<Laptop> findByBrandAndModel(String Brand, String model);

    void delete(Laptop laptop);

    List<Laptop> findAllByBrand(String brand);
}
