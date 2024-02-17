package com.tobeto.pair9.controllers;

import com.tobeto.pair9.core.utilities.results.BaseResponse;
import com.tobeto.pair9.core.utilities.results.DataResult;
import com.tobeto.pair9.services.abstracts.ForgotPasswordService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/password")
@CrossOrigin
public class ForgotPasswordController {

    private final ForgotPasswordService forgotPasswordService;

    @PostMapping("/send-email") //Forgot Password
    public BaseResponse savePasswordRequest(@RequestParam("email")String email) throws MessagingException, UnsupportedEncodingException {
         return forgotPasswordService.checkUserDetails(email);
    }

    @PostMapping("/reset-password")
    public BaseResponse saveResetPassword(@RequestParam("token") String token, @RequestParam("password") String password){
        return forgotPasswordService.resetPassword(token,password);
    }
}
