package com.desafiotecnico.eclipsehotel.controller;

import com.desafiotecnico.eclipsehotel.entity.Reservation;
import com.desafiotecnico.eclipsehotel.entity.Rooms;
import com.desafiotecnico.eclipsehotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation createReservation(
            @RequestParam Integer customerId,
            @RequestParam Integer roomId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate) {
        return reservationService.createReservation(customerId, roomId, checkInDate, checkOutDate);
    }

    @PutMapping("/{id}/finish")
    public Reservation finishReservation(@PathVariable Integer id) {
        return reservationService.finishReservation(id);
    }

    @GetMapping("/by-date-range")
    public List<Reservation> getReservationsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return reservationService.getReservationsByDateRange(startDate, endDate);
    }

    @GetMapping("/occupied-rooms")
    public List<Rooms> getOccupiedRooms() {
        return reservationService.getOccupiedRooms();
    }
}
