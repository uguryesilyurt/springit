package com.ugur.springit.service;

import com.ugur.springit.domain.User;
import com.ugur.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final MailService mailService;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, RoleService roleService, MailService mailService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.mailService = mailService;
        encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {
       String secret = "{bcrypt}" + encoder.encode(user.getPassword());
       user.setEnabled(false);
       user.setPassword(secret);
       user.setConfirmPassword(secret);
       user.addRole(roleService.findByName("ROLE_USER"));
       user.setActivationCode(UUID.randomUUID().toString());
       save(user);
       sendActivationEmail(user);
       return user;
   }

   public User save(User user) {
       return userRepository.save(user);
   }


    @Transactional
    public void saveUsers(User... users) {
        for(User user : users) {
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }

    private void sendActivationEmail(User user) {
       mailService.sendActivationEmail(user);
    }

    public void sendWelcomeEmail(User user) {
        mailService.sendWelcomeEmail(user);
    }

    public Optional<User> findByEmailAndActivationCode(String email, String activationCode) {
        return userRepository.findByEmailAndActivationCode(email,activationCode);
    }


}
