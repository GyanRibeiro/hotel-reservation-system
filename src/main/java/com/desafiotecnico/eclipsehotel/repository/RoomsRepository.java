package com.desafiotecnico.eclipsehotel.repository;

import com.desafiotecnico.eclipsehotel.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
}
