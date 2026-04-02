package com.petstay.service.impl;

import com.petstay.dto.PetRequestDTO;
import com.petstay.dto.PetResponseDTO;
import com.petstay.entity.Pet;
import com.petstay.entity.Tutor;
import com.petstay.repository.PetRepository;
import com.petstay.repository.TutorRepository;
import com.petstay.service.interfaces.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PetServiceImpl implements PetService {

    @Autowired private PetRepository petRepository;
    @Autowired private TutorRepository tutorRepository;

    @Override
    public PetResponseDTO create(UUID tutorId, PetRequestDTO dto) {
        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));

        Pet pet = Pet.builder()
                .name(dto.name())
                .breed(dto.breed())
                .healthNotes(dto.healthNotes())
                .tutor(tutor)
                .build();

        return toDTO(petRepository.save(pet));
    }

    @Override
    public List<PetResponseDTO> findByTutor(UUID tutorId) {
        return petRepository.findByTutorId(tutorId)
                .stream().map(this::toDTO).toList();
    }

    @Override
    public PetResponseDTO update(UUID petId, PetRequestDTO dto) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        pet.setName(dto.name());
        pet.setBreed(dto.breed());
        pet.setHealthNotes(dto.healthNotes());

        return toDTO(petRepository.save(pet));
    }

    private PetResponseDTO toDTO(Pet pet) {
        return new PetResponseDTO(
                pet.getId(),
                pet.getName(),
                pet.getBreed(),
                pet.getHealthNotes(),
                pet.getTutor().getName()
        );
    }
}
