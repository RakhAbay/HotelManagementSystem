package com.hotel.repositories;

import com.hotel.data.interfaces.IDB;
import com.hotel.entities.Guest;
import com.hotel.repositories.interfaces.IGuestRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class GuestRepository implements IGuestRepository {

    private final IDB db;

    public GuestRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean registerGuest(Guest guest) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO guests(name, surname, age, gender) VALUES (?,?,?,?)");

            st.setString(1, guest.getName());
            st.setString(2, guest.getSurname());
            st.setInt(3, guest.getAge());
            st.setString(4, guest.getGender());

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
    public Guest getGuest(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT guestId, name, surname, age, gender FROM guests WHERE guestId=?");

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Guest guest = new Guest(rs.getInt("guestId"), rs.getString("name"), rs.getString("surname"), rs.getInt("age"), rs.getString("gender"));

                return guest;
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
    public List<Guest> getAllGuests() {
        Connection con = null;
        try {
            con = db.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT guestId, name, surname, age, gender FROM guests");
            List<Guest> users = new LinkedList<>();
            while (rs.next()) {
                Guest guest = new Guest(rs.getInt("guestId"), rs.getString("name"), rs.getString("surname"), rs.getInt("age"), rs.getString("gender"));

                users.add(guest);
            }

            return users;
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

    public boolean removeGuest(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("DELETE FROM guests WHERE guestId=?");

            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Invalid " + e);
        }
        return false;
    }
    }

