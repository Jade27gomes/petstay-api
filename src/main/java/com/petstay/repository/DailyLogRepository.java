package com.petstay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petstay.entity.DailyLog;
import java.util.List;
import java.util.UUID;

@Repository
public interface DailyLogRepository extends JpaRepository<DailyLog, UUID> {
    List<DailyLog> findByBookingId(UUID bookingId);
}
