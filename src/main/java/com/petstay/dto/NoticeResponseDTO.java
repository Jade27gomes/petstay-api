package com.petstay.dto;
import java.time.LocalDateTime;
import java.util.UUID;

public record NoticeResponseDTO(
    UUID id,
    String title,
    String content,
    LocalDateTime createdAt,
    String authorName
) {}
