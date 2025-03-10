package com.desafiotecnico.eclipsehotel.service;

import com.desafiotecnico.eclipsehotel.entity.Customer;
import com.desafiotecnico.eclipsehotel.entity.Reservation;
import com.desafiotecnico.eclipsehotel.entity.Rooms;
import com.desafiotecnico.eclipsehotel.entity.StatusReservation;
import com.desafiotecnico.eclipsehotel.repository.CustomerRepository;
import com.desafiotecnico.eclipsehotel.repository.ReservationRepository;
import com.desafiotecnico.eclipsehotel.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomsRepository roomRepository;

    public Reservation createReservation(Integer customerId, Integer roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Rooms room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        reservation.setCheckInDate(checkInDate);
        reservation.setCheckOutDate(checkOutDate);
        reservation.setStatus(StatusReservation.SCHEDULED);

        return reservationRepository.save(reservation);
    }

    public Reservation finishReservation(Integer reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setStatus(StatusReservation.FINISHED);
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByDateRange(LocalDate startDate, LocalDate endDate) {
        return reservationRepository.findByCheckInDateBetween(startDate, endDate);
    }

    public List<Rooms> getOccupiedRooms() {
        List<Reservation> reservations = reservationRepository.findByStatus("IN_USE");
        return reservations.stream()
                .map(Reservation::getRoom)
                .collect(Collectors.toList());
    }
}
