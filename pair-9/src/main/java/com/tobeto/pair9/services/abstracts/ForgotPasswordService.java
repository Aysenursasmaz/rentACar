package com.tobeto.pair9.services.abstracts;

import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public interface ForgotPasswordService {

     String generateToken();

     LocalDateTime expireDateRange();

     void sendEmail(String to, String subject,String emailLink) throws MessagingException, UnsupportedEncodingException;
}
