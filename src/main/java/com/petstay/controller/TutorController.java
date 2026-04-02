package com.petstay.controller;

import com.petstay.dto.TutorRequestDTO;
import com.petstay.dto.TutorResponseDTO;
import com.petstay.service.interfaces.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    @Autowired private TutorService tutorService;


    @GetMapping("/me")
    public ResponseEntity<TutorResponseDTO> getMe(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(tutorService.getMe(user.getUsername()));
    }


    @PutMapping("/me")
    public ResponseEntity<TutorResponseDTO> updateMe(
            @AuthenticationPrincipal UserDetails user,
            @Valid @RequestBody TutorRequestDTO dto) {
        return ResponseEntity.ok(tutorService.updateMe(user.getUsername(), dto));
    }


    @GetMapping
    public ResponseEntity<List<TutorResponseDTO>> findAll() {
        return ResponseEntity.ok(tutorService.findAll());
    }
}
