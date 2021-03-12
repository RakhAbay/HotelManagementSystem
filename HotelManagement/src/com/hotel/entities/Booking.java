package com.hotel.entities;


import java.sql.Date;

public class Booking {

    private int bookingId;
    private int guestId;
    private int roomId;
    private Date dateIn;
    private Date dateOut;
    private String extraDescription;

    public Booking(int bookingId, int guestId, int roomId, Date dateIn, Date dateOut, String extraDescription) {
        this.bookingId = bookingId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.extraDescription = extraDescription;
    }
    public Booking(int guestId, int roomId, Date dateIn, Date dateOut, String extraDescription) {
        this.guestId = guestId;
        this.roomId = roomId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.extraDescription = extraDescription;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    @Override
    public String toString() {
        return "ID: " + bookingId + '\n' +
               "Guest's ID: " + guestId + '\n' +
               "Room ID: " + roomId + '\n' +
               "Date of arrival: " + dateIn + '\n' +
               "Ending date: " + dateOut + '\n' +
               "Description: " + extraDescription + '\n' + '\n';
    }
}