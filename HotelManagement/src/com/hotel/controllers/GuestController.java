package com.hotel.controllers;

import com.hotel.entities.Guest;
import com.hotel.repositories.interfaces.IGuestRepository;

import java.util.List;

public class GuestController {

    private final IGuestRepository guestRepository;

    public GuestController(IGuestRepository repo) {
        this.guestRepository = repo;
    }

    public String registerGuest(String name, String surname, int age, String gender) {

        Guest guest = new Guest(name, surname, age, gender);

        boolean created = guestRepository.registerGuest(guest);

        return (created ? "Guest was created!" : "Guest creation was failed!");
    }

    public String getGuest(int id) {
        Guest guest = guestRepository.getGuest(id);

        return (guest == null ? "User was not found!" : guest.toString());
    }

    public String getAllGuests() {
        List<Guest> guests = guestRepository.getAllGuests();

        return guests.toString();
    }

    public String removeGuest(int id)  {

        boolean removed = guestRepository.removeGuest(id);

        return removed ? "Successfully removed" : "Invalid ID";
    }
}
