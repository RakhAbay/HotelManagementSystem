package com.hotel.repositories.interfaces;

import com.hotel.entities.Guest;

import java.util.List;

public interface IGuestRepository {
    boolean registerGuest(Guest guest);
    Guest getGuest(int id);
    List<Guest> getAllGuests();
    boolean removeGuest(int id);
}
