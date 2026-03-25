package com.petstay.dto;
import java.util.UUID;

public record TutorResponseDTO(
    UUID id,
    String name,
    String phone,
    String email
) {}
