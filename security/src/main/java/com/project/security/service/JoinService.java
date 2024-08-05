package com.project.security.service;


import com.project.security.dto.JoinDto;
import com.project.security.entity.User;
import com.project.security.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    private UserRepository userRepository;

    public JoinService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void join(JoinDto joinDto) {
        String username = joinDto.getUsername();
        String password = joinDto.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {
            return;
        }

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setRole("ROLE_ADMIN");

        userRepository.save(user);
    }
}
