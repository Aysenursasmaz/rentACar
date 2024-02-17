package com.tobeto.pair9.repositories;

import com.tobeto.pair9.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    boolean existsByName(String name);

    Optional<Brand> getBrandByName(String name);
}
