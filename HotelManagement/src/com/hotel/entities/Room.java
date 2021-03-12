package com.hotel.entities;

public class Room {

    private int roomId;
    private String type;
    private int seats;
    private int cost;





    public Room(int roomId, String type, int seats, int cost) {
        this.roomId = roomId;
        this.type = type;
        this.seats = seats;
        this.cost = cost;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Room number: " + roomId + '\n' +
               "Type: " + type + '\n' +
               "Number of seats: " + seats + '\n' +
               "Cost per night: " + cost  + '\n' + '\n';
    }
}
