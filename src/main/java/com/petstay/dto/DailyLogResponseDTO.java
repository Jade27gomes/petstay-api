package com.petstay.dto;
import java.time.LocalDate;
import java.util.UUID;

public record DailyLogResponseDTO(
    UUID id,
    String feeding,
    String activities,
    String notes,
    LocalDate date
) {}
