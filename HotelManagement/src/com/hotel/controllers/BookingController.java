package com.hotel.controllers;

import com.hotel.entities.Booking;
import com.hotel.repositories.interfaces.IBookingRepository;

import java.sql.Date;
import java.util.List;

public class BookingController {

    private final IBookingRepository bookingRepository;

    public BookingController(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public String createBooking(int guestId, int roomId, Date dateIn, Date dateOut, String extraDescription) {

        Booking booking = new Booking(guestId, roomId, dateIn, dateOut, extraDescription);

        boolean created = bookingRepository.createBooking(booking);

        return (created ? "Booking was created!" : "Booking creation was failed!");
    }

    public String getBooking(int id) {
        Booking booking = bookingRepository.getBooking(id);

        return (booking == null ? "Booking was not found!" : booking.toString());
    }

    public String getAllBookings() {
        List<Booking> bookings = bookingRepository.getAllBookings();

        return bookings.toString();
    }

    public String cancelBooking(int id)  {

        boolean removed = bookingRepository.cancelBooking(id);

        return removed ? "Successfully removed" : "Invalid ID";
    }

}
