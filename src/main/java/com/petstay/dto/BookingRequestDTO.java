package com.petstay.dto;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public record BookingRequestDTO(
    @NotNull UUID petId,
    @NotNull LocalDateTime checkIn,
    @NotNull LocalDateTime checkOut
) {}
