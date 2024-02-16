package com.tobeto.pair9.controllers;

import com.tobeto.pair9.entities.concretes.ForgotPasswordToken;
import com.tobeto.pair9.entities.concretes.User;
import com.tobeto.pair9.services.abstracts.ForgotPasswordService;
import com.tobeto.pair9.services.abstracts.UserService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/password")
public class ForgotPasswordController {

    private UserService userService;
    private ForgotPasswordService forgotPasswordService;

    @GetMapping("/password-request")
    public String passwordRequest(){
        return  "password-request";
    }

    @PostMapping("/password-request") //Forgot Password
    public String savePasswordRequest(@RequestParam("email")String email) throws MessagingException, UnsupportedEncodingException {
        User user = userService.getUserByEmail(email);
        if(user == null){
            return "Email is not found";
        }
        ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken();
        forgotPasswordToken.setExpireTime(forgotPasswordService.expireDateRange());
        forgotPasswordToken.setToken(forgotPasswordService.generateToken());
        forgotPasswordToken.setUser(user);
        forgotPasswordToken.setUsed(false);
        String emailLink = "http:localhost:8080/reset-password?token= " + forgotPasswordToken.getToken();
        try{
            forgotPasswordService.sendEmail(user.getEmail(),"Password Reset Link",emailLink);
        }catch (UnsupportedEncodingException | MessagingException e){
            return "Error While Sending email ";
        }
        return  "redirect:/password-request?success";
    }

    @GetMapping("/reset-password")
    public String resetPassword(){
        return  "reset-password";
    }

    @PostMapping("/reset-password")
    public String saveResetPassword(){
        return  "reset-password";
    }

}
