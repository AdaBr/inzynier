package com.example.library.service;

import com.example.library.commons.Constans;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public User findByEmail(String emial) {
        return userRepository.findByEmail(emial);
    }

    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }


    public boolean registerNewUser(User user) {

        if (userRepository.findByEmail(user.getEmail())!=null) {
            return false;
        }
        else {
            user.setEnabled(false);

            user.setConfirmationToken(UUID.randomUUID().toString());

            userRepository.save(user);

            String appUrl = Constans.SERVER_URL;

            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation to Library");
            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getConfirmationToken());
            registrationEmail.setFrom("noreply@domain.com");

            emailService.sendEmail(registrationEmail);
            return true;
        }

    }

    public boolean confirmRegistration(String token) {
        User user = userRepository.findByConfirmationToken(token);

        if (userRepository.findByConfirmationToken(token) == null) {
            return false;
        } else {
            user.setEnabled(true);
            return true;
        }
    }
}
