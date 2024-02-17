package com.tobeto.pair9.repositories;

import com.tobeto.pair9.entities.concretes.ForgotPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordToken,Integer> {

    ForgotPasswordToken findByToken(String token);

}
