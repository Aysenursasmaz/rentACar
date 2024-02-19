package com.tobeto.pair9.repositories;

import com.tobeto.pair9.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color,Integer> {

    boolean existsByName(String name);

    Optional<Color> getColorByName(String name);
}
