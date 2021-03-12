package com.hotel.repositories.interfaces;

import com.hotel.entities.Room;

import java.util.List;

public interface IRoomRepository {
    boolean createRoom(Room room);
    Room getRoom(int id);
    List<Room> getAllRooms();
    List<Room> getAvailableRooms(String date1,String date2);
}
