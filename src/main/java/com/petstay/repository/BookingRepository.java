package com.petstay.repository;

import com.petstay.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
    // Busca todas as reservas de um tutor (através do pet)
    List<Booking> findByPetTutorId(UUID tutorId);
}
