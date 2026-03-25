package com.petstay.dto;
import jakarta.validation.constraints.NotBlank;

public record NoticeRequestDTO(
    @NotBlank String title,
    @NotBlank String content
) {}
