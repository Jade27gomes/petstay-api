package com.petstay.service.interfaces;

import com.petstay.dto.CreateUserRequestDTO;
import com.petstay.dto.LoginRequestDTO;
import com.petstay.dto.LoginResponseDTO;
import com.petstay.dto.RegisterRequestDTO;
import com.petstay.dto.UserResponseDTO;

public interface AuthService {
    UserResponseDTO register(RegisterRequestDTO dto);
    LoginResponseDTO login(LoginRequestDTO dto);
    UserResponseDTO createUser(CreateUserRequestDTO dto);
}
