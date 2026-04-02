package com.petstay.dto;

import com.petstay.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CreateUserRequestDTO(
    @NotBlank String name,
    @NotBlank @Email String email,
    @NotBlank String password,
    String phone,
    @NotNull Role role
) {}

