package com.hotel;

import com.hotel.controllers.BookingController;
import com.hotel.controllers.GuestController;
import com.hotel.controllers.RoomController;
import com.hotel.data.PostgresDB;
import com.hotel.data.interfaces.IDB;
import com.hotel.repositories.BookingRepository;
import com.hotel.repositories.GuestRepository;
import com.hotel.repositories.RoomRepository;
import com.hotel.repositories.interfaces.IBookingRepository;
import com.hotel.repositories.interfaces.IGuestRepository;
import com.hotel.repositories.interfaces.IRoomRepository;

public class Main {
    public static void main(String[] args) {

        IDB db = new PostgresDB();

        IGuestRepository guestRepository = new GuestRepository(db);
        GuestController guestController = new GuestController(guestRepository);

        IRoomRepository roomRepository = new RoomRepository(db);
        RoomController roomController = new RoomController(roomRepository);

        IBookingRepository bookingRepository = new BookingRepository(db);
        BookingController bookingController = new BookingController(bookingRepository);

        MyApplication app = new MyApplication(guestController, roomController, bookingController);
        app.start();
    }
}
