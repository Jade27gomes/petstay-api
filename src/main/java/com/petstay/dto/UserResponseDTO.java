package com.petstay.dto;

import com.petstay.enums.Role;
import java.util.UUID;

public record UserResponseDTO(
    UUID id,
    String email,
    Role role
) {}
// Note: NÃO colocamos o campo password aqui. Segurança em primeiro lugar!
