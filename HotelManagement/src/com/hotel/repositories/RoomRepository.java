package com.hotel.repositories;

import com.hotel.data.interfaces.IDB;
import com.hotel.entities.Room;
import com.hotel.repositories.interfaces.IRoomRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RoomRepository implements IRoomRepository {

    private final IDB db;

    public RoomRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createRoom(Room room) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO rooms(roomId, type, seats, cost) VALUES (?,?,?,?)");

            st.setInt(1, room.getRoomId());
            st.setString(2, room.getType());
            st.setInt(3, room.getSeats());
            st.setInt(4, room.getCost());

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
    public Room getRoom(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT roomId, type, seats, cost FROM rooms WHERE roomId=?");

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Room room = new Room(rs.getInt("roomId"), rs.getString("type"), rs.getInt("seats"), rs.getInt("cost"));

                return room;
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
    public List<Room> getAllRooms() {
        Connection con = null;
        try {
            con = db.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT roomId, type, seats, cost FROM rooms");
            List<Room> rooms = new LinkedList<>();
            while (rs.next()) {
                Room room = new Room(rs.getInt("roomId"), rs.getString("type"), rs.getInt("seats"), rs.getInt("cost"));
                rooms.add(room);
            }

            return rooms;
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
    public List<Room> getAvailableRooms(String date1, String date2) {
        Connection con = null;
        try {
            con = db.getConnection();

            PreparedStatement pst = con.prepareStatement("select * from rooms where roomId not in ( select rooms.roomId from rooms join bookings on rooms.roomId = bookings.roomId where ?::date <= dateIn::date and ?::date <= dateOut::date and ?::date >= dateOut::date and ?::date >= dateIn::date)");

            System.out.println(date1+" "+date2);
            pst.setString(1, date1);
            pst.setString(2, date1);
            pst.setString(3, date2);
            pst.setString(4, date2);

            ResultSet rs = pst.executeQuery();
            List<Room> rooms = new LinkedList<>();
            while (rs.next()) {
                Room room = new Room(rs.getInt("roomId"), rs.getString("type"), rs.getInt("seats"), rs.getInt("cost"));
                rooms.add(room);
            }

            return rooms;
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
}
