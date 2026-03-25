package com.petstay.dto;
import com.petstay.enums.BookingStatus;
import java.time.LocalDateTime;
import java.util.UUID;

public record BookingResponseDTO(
    UUID id,
    LocalDateTime checkIn,
    LocalDateTime checkOut,
    BookingStatus status,
    String petName
) {}
