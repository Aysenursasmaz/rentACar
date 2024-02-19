package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.exceptions.ForgotPasswordBusinessException;
import com.tobeto.pair9.core.utilities.results.BaseResponse;
import com.tobeto.pair9.core.utilities.results.DataResult;
import com.tobeto.pair9.core.utilities.results.Messages;
import com.tobeto.pair9.entities.concretes.ForgotPasswordToken;
import com.tobeto.pair9.entities.concretes.User;
import com.tobeto.pair9.repositories.ForgotPasswordRepository;
import com.tobeto.pair9.services.abstracts.ForgotPasswordService;
import com.tobeto.pair9.services.abstracts.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ForgotPasswordManager implements ForgotPasswordService {

    @Value("${forgot.password.token.expiration}")
    private int MINUTES;
    private final JavaMailSender javaMailSender;
    private final UserService userService;
    private final ForgotPasswordRepository forgotPasswordRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public LocalDateTime expireDateRange() {
        return LocalDateTime.now().plusMinutes(MINUTES);
    }

    @Override
    public void sendEmail(String to, String subject, String emailLink) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String emailContent = Messages.forgotPasswordMailContent1
                + emailLink + Messages.forgotPasswordMailContent2;
        helper.setFrom(Messages.email);
        helper.setTo(to);
        helper.setText(emailContent,true);
        helper.setSubject(subject);
        javaMailSender.send(message);
    }

    public BaseResponse checkUserDetails(String email){
        User user = userService.getUserByEmail(email);
        ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken();
        forgotPasswordToken.setToken(generateToken());
        forgotPasswordToken.setUser(user);
        forgotPasswordToken.setExpireTime(expireDateRange());
        forgotPasswordToken.setUsed(false);

        forgotPasswordRepository.save(forgotPasswordToken);

        String emailLink = Messages.emailLink + forgotPasswordToken.getToken();
        try{
            sendEmail(user.getEmail(),Messages.emailSubject,emailLink);
        }catch (UnsupportedEncodingException | MessagingException e){
            return new DataResult<>(true,Messages.errorSendingEmail);
        }
        return new BaseResponse(true,Messages.successSendingEmail);
    }

    @Override
    public boolean isExpired(ForgotPasswordToken forgotPasswordToken) {
        return LocalDateTime.now().isAfter(forgotPasswordToken.getExpireTime());
    }

    public void checkValidity(ForgotPasswordToken forgotPasswordToken){
        if(forgotPasswordToken == null){
            throw new ForgotPasswordBusinessException(Messages.tokenIsAlreadyUsed);
        } else if (isExpired(forgotPasswordToken)) {
            throw new ForgotPasswordBusinessException(Messages.tokenIsExpired);
        }
        else if (forgotPasswordToken.isUsed()){
            throw new ForgotPasswordBusinessException(Messages.tokenIsAlreadyUsed);
        }
    }

    @Override
    public BaseResponse resetPassword(String token, String password) {
        ForgotPasswordToken forgotPasswordToken = forgotPasswordRepository.findByToken(token);
        checkValidity(forgotPasswordToken);
        User user = forgotPasswordToken.getUser();
        user.setPassword(passwordEncoder.encode(password));
        forgotPasswordToken.setUsed(true);
        userService.save(user);
        forgotPasswordRepository.save(forgotPasswordToken);
        return new BaseResponse(true,Messages.passwordChanged);
    }
}
