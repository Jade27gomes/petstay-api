package com.petstay.service.impl;

import com.petstay.dto.CreateUserRequestDTO;
import com.petstay.dto.LoginRequestDTO;
import com.petstay.dto.LoginResponseDTO;
import com.petstay.dto.RegisterRequestDTO;
import com.petstay.dto.UserResponseDTO;
import com.petstay.config.security.TokenService;
import com.petstay.entity.Tutor;
import com.petstay.entity.User;
import com.petstay.enums.Role;
import com.petstay.repository.TutorRepository;
import com.petstay.repository.UserRepository;
import com.petstay.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService, UserDetailsService {

    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private TokenService tokenService;
    @Autowired private TutorRepository tutorRepository;

    // Usado pelo Spring Security internamente para autenticar
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));
    }

    @Override
    public UserResponseDTO register(RegisterRequestDTO dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("E-mail já cadastrado");
        }
        User user = User.builder()
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .role(Role.CLIENTE)
                .build();

        User saved = userRepository.save(user);
        return new UserResponseDTO(saved.getId(), saved.getEmail(), saved.getRole());
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = (User) loadUserByUsername(dto.email());

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        String token = tokenService.generateToken(user);
        return new LoginResponseDTO(token);
    }

    @Override
    public UserResponseDTO createUser(CreateUserRequestDTO dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        User user = User.builder()
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .role(dto.role())
                .build();
        User saved = userRepository.save(user);

        Tutor tutor = Tutor.builder()
                .name(dto.name())
                .phone(dto.phone())
                .user(saved)
                .build();
        tutorRepository.save(tutor);

        return new UserResponseDTO(saved.getId(), saved.getEmail(), saved.getRole());
    }
}
