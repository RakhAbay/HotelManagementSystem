package com.hotel.repositories.interfaces;

import com.hotel.entities.Booking;

import java.util.List;

public interface IBookingRepository {
    boolean createBooking(Booking booking);
    Booking getBooking(int id);
    List<Booking> getAllBookings();
    boolean cancelBooking(int id);
}
