package com.petstay.dto;

import jakarta.validation.constraints.*;

public record RegisterRequestDTO(
    @NotBlank String name,
    @NotBlank
    @Email String email,
    @NotBlank
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    String password,
    String phone
) {}
