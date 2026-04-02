package com.petstay.dto;

import jakarta.validation.constraints.NotBlank;

public record TutorRequestDTO(
    @NotBlank String name,
    String phone,
    java.util.UUID financialResponsibleId 
) {}
