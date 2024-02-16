package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.services.abstracts.ForgotPasswordService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ForgetPasswordManager  implements ForgotPasswordService {

    private final int MINUTES = 10;
    private final JavaMailSender javaMailSender;

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
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String emailContent = "Hello\n" +
                "A request has been received to change the password" +
                " for your account " + emailLink +
                "\n\n" +
                "If you did not initiate this request, please contact " +
                "ys immediately at support@rentacar9.com " +
                "\n\n" +
                "Thank You,\n" +
                "The Pair-9 Team :)";

        helper.setText(emailContent,true);
        helper.setFrom("rentacarpair9@gmail.com","Renting Car Pair-9 Support");
        helper.setSubject(subject);
        helper.setText(to);
        javaMailSender.send(message);
    }
}
