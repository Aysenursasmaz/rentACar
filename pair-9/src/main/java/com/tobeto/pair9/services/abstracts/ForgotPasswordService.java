package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.core.utilities.results.BaseResponse;
import com.tobeto.pair9.entities.concretes.ForgotPasswordToken;
import jakarta.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public interface ForgotPasswordService {

     String generateToken();

     LocalDateTime expireDateRange();

     void sendEmail(String to, String subject,String emailLink) throws MessagingException, UnsupportedEncodingException;

     BaseResponse checkUserDetails(String email);

     boolean isExpired (ForgotPasswordToken forgotPasswordToken);

     BaseResponse resetPassword(String token, String password);

     void checkValidity(ForgotPasswordToken forgotPasswordToken);
}

