package com.petstay.controller;

import com.petstay.dto.PetRequestDTO;
import com.petstay.dto.PetResponseDTO;
import com.petstay.service.interfaces.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PetController {

    @Autowired private PetService petService;

    @PostMapping("/tutors/{tutorId}/pets")
    public ResponseEntity<PetResponseDTO> create(
            @PathVariable UUID tutorId,
            @Valid @RequestBody PetRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.create(tutorId, dto));
    }

    @GetMapping("/tutors/{tutorId}/pets")
    public ResponseEntity<List<PetResponseDTO>> findByTutor(@PathVariable UUID tutorId) {
        return ResponseEntity.ok(petService.findByTutor(tutorId));
    }

    @PutMapping("/pets/{petId}")
    public ResponseEntity<PetResponseDTO> update(
            @PathVariable UUID petId,
            @Valid @RequestBody PetRequestDTO dto) {
        return ResponseEntity.ok(petService.update(petId, dto));
    }
}
