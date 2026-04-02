package com.petstay.service.impl;

import com.petstay.dto.TutorRequestDTO;
import com.petstay.dto.TutorResponseDTO;
import com.petstay.entity.Tutor;
import com.petstay.repository.TutorRepository;
import com.petstay.service.interfaces.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

    @Autowired private TutorRepository tutorRepository;

    @Override
    public TutorResponseDTO getMe(String email) {
        Tutor tutor = tutorRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));
        return toDTO(tutor);
    }

    @Override
    public TutorResponseDTO updateMe(String email, TutorRequestDTO dto) {
        Tutor tutor = tutorRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));

        tutor.setName(dto.name());
        tutor.setPhone(dto.phone());

        if (dto.financialResponsibleId() != null) {
            Tutor responsible = tutorRepository.findById(dto.financialResponsibleId())
                    .orElseThrow(() -> new RuntimeException("Responsável financeiro não encontrado"));
            tutor.setFinancialResponsible(responsible);
        }

        return toDTO(tutorRepository.save(tutor));
    }

    @Override
    public List<TutorResponseDTO> findAll() {
        return tutorRepository.findAll().stream().map(this::toDTO).toList();
    }

    private TutorResponseDTO toDTO(Tutor tutor) {
        return new TutorResponseDTO(
                tutor.getId(),
                tutor.getName(),
                tutor.getPhone(),
                tutor.getUser().getUsername()
        );
    }
}
