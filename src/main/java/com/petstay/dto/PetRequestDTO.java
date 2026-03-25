package com.petstay.dto;

import jakarta.validation.constraints.NotBlank;

public record PetRequestDTO(
    @NotBlank(message = "O nome do pet é obrigatório")
    String name,
    String breed,
    String healthNotes
) {}
