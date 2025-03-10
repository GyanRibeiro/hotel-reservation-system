package com.desafiotecnico.eclipsehotel.controller;

import com.desafiotecnico.eclipsehotel.entity.Rooms;
import com.desafiotecnico.eclipsehotel.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
    @Autowired
    private RoomsService roomService;

    @GetMapping
    public List<Rooms> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Rooms getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Rooms createRoom(@RequestBody Rooms room) {
        return roomService.createRoom(room);
    }

    @PutMapping("/{id}")
    public Rooms updateRoom(@PathVariable Integer id, @RequestBody Rooms roomDetails) {
        return roomService.updateRoom(id, roomDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
    }
}
