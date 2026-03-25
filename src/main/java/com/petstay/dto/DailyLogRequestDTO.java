package com.petstay.dto;
import jakarta.validation.constraints.NotBlank;

public record DailyLogRequestDTO(
    @NotBlank String feeding,
    String activities,
    String notes
) {}
