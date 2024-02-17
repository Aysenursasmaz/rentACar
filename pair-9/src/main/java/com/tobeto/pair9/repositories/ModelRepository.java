package com.tobeto.pair9.repositories;

import com.tobeto.pair9.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model,Integer> {

    boolean existsByName(String name);

    boolean existsBrandById(Integer id);

    Optional<Model> getModelByName(String name);

}
