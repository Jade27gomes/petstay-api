package com.petstay.service.interfaces;

import com.petstay.dto.TutorRequestDTO;
import com.petstay.dto.TutorResponseDTO;
import java.util.List;

public interface TutorService {
    TutorResponseDTO getMe(String email);
    TutorResponseDTO updateMe(String email, TutorRequestDTO dto);
    List<TutorResponseDTO> findAll(); // só ADMIN
}
