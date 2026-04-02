package com.petstay.service.interfaces;

import com.petstay.dto.PetRequestDTO;
import com.petstay.dto.PetResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PetService {
    PetResponseDTO create(UUID tutorId, PetRequestDTO dto);
    List<PetResponseDTO> findByTutor(UUID tutorId);
    PetResponseDTO update(UUID petId, PetRequestDTO dto);
}
