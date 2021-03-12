package com.hotel.controllers;

import com.hotel.entities.Room;
import com.hotel.repositories.interfaces.IRoomRepository;

import java.util.List;

public class RoomController {
    private final IRoomRepository roomRepository;

    public RoomController(IRoomRepository repo) {
        this.roomRepository = repo;
    }

    public String createRoom(int roomId, String type, int seats, int cost) {

        Room room = new Room(roomId, type, seats, cost);

        boolean created = roomRepository.createRoom(room);

        return (created ? "Room was created!" : "Room creation was failed!");
    }

    public String getRoom(int id) {
        Room room = roomRepository.getRoom(id);

        return (room == null ? "Room was not found!" : room.toString());
    }

    public String getAllRooms() {
        List<Room> rooms = roomRepository.getAllRooms();

        return rooms.toString();
    }

    public String getAvailableRooms(String date1, String date2) {
        List<Room> rooms = roomRepository.getAvailableRooms(date1, date2);

        return rooms.toString();
    }
}
