package com.petstay.dto;

import java.util.UUID;

public record PetResponseDTO(
    UUID id,
    String name,
    String breed,
    String healthNotes,
    String tutorName 
) {}
