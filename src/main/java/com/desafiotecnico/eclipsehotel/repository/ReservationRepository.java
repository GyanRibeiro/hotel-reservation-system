package com.desafiotecnico.eclipsehotel.repository;

import com.desafiotecnico.eclipsehotel.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByCheckInDateBetween(LocalDate startDate, LocalDate endDate);
    List<Reservation> findByStatus(String status);
}
