package com.desafiotecnico.eclipsehotel.service;

import com.desafiotecnico.eclipsehotel.entity.Rooms;
import com.desafiotecnico.eclipsehotel.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsService {
    @Autowired
    private RoomsRepository roomRepository;

    public List<Rooms> getAllRooms() {
        return roomRepository.findAll();
    }

    public Rooms getRoomById(Integer id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public Rooms createRoom(Rooms room) {
        return roomRepository.save(room);
    }

    public Rooms updateRoom(Integer id, Rooms roomDetails) {
        Rooms room = getRoomById(id);
        room.setRoomNumber(roomDetails.getRoomNumber());
        room.setRoomType(roomDetails.getRoomType());
        room.setPrice(roomDetails.getPrice());
        return roomRepository.save(room);
    }

    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }
}
