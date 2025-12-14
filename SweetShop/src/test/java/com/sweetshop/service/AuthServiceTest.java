package com.sweetshop.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


import com.shop.Service.AuthService;
import com.shop.model.Role;
import com.shop.model.User;
import com.shop.repository.UserRepository;

import dto.RegisterRequest;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    @Test
    void shouldRegisterUser() {
        RegisterRequest request = new RegisterRequest("laxmi", "123");

        when(passwordEncoder.encode("123"))
                .thenReturn("encoded");

        when(userRepository.save(any(User.class)))
                .thenAnswer(i -> i.getArgument(0));

        User user = authService.register(request);

        assertEquals("laxmi", user.getUsername());
        assertEquals(Role.USER, user.getRole());
    }
}
