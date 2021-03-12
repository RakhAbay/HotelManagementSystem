package com.hotel.repositories;

import com.hotel.data.interfaces.IDB;
import com.hotel.entities.Booking;
import com.hotel.repositories.interfaces.IBookingRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookingRepository implements IBookingRepository {

    private final IDB db;

    public BookingRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createBooking(Booking booking) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO bookings(guestId, roomId, dateIn, dateOut, extraDescription) VALUES (?,?,?,?,?)");


            st.setInt(1, booking.getGuestId());
            st.setInt(2, booking.getRoomId());
            st.setDate(3, booking.getDateIn());
            st.setDate(4, booking.getDateOut());
            st.setString(5, booking.getExtraDescription());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Booking getBooking(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT bookingId, guestId, roomId, dateIn, dateOut, extraDescription FROM bookings WHERE bookingId=?");

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("bookingId"),
                        rs.getInt("guestId"),
                        rs.getInt("roomId"),
                        rs.getDate("dateIn"),
                        rs.getDate("dateOut"),
                        rs.getString("extraDescription")
                );

                return booking;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        Connection con = null;
        try {
            con = db.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT bookingId, guestId, roomId, dateIn, dateOut, extraDescription FROM bookings");
            List<Booking> bookings = new LinkedList<>();
            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("bookingId"),
                        rs.getInt("guestId"),
                        rs.getInt("roomId"),
                        rs.getDate("dateIn"),
                        rs.getDate("dateOut"),
                        rs.getString("extraDescription")
                );

                bookings.add(booking);
            }

            return bookings;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean cancelBooking(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("DELETE FROM bookings WHERE bookingId=?");

            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Invalid ID" + e);
        }
        return false;
    }
}
