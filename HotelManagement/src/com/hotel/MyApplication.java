package com.hotel;

import com.hotel.controllers.BookingController;
import com.hotel.controllers.GuestController;
import com.hotel.controllers.RoomController;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MyApplication {

    private final GuestController guestController;
    private final RoomController roomController;
    private final BookingController bookingController;

    private final Scanner sc;

    public MyApplication(GuestController guestController, RoomController roomController, BookingController bookingController) {
        this.guestController = guestController;
        this.roomController = roomController;
        this.bookingController = bookingController;
        sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to Hotel Management Application");
            System.out.println("Select option:");
            System.out.println("1. Get all guests");
            System.out.println("2. Get a guest by id");
            System.out.println("3. Create a guest");
            System.out.println("4. Remove a guest");
            System.out.println("");
            System.out.println("5. Get all rooms");
            System.out.println("6. Get a room by number(id)");
            System.out.println("7. Create room");
            System.out.println("8. See available rooms at a specific period");
            System.out.println("");
            System.out.println("9. Get all bookings");
            System.out.println("10. Get a booking by id");
            System.out.println("11. Create booking");
            System.out.println("12. Cancel booking");

            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option: ");
                int option = sc.nextInt();
                if (option == 1) {
                    getAllGuestsMenu();
                } else if (option == 2) {
                    getGuestByIdMenu();
                } else if (option == 3) {
                    createGuestMenu();
                } else if (option == 4) {
                    removeGuestMenu();
                } else if (option == 5) {
                    getAllRoomsMenu();
                } else if (option == 6) {
                    getRoomByIdMenu();
                } else if (option == 7) {
                    addRoomMenu();
                } else if (option == 8) {
                    getAvailableRoomsMenu();
                } else if (option == 9) {
                    getAllBookingsMenu();
                } else if (option == 10) {
                    getBookingByIdMenu();
                } else if (option == 11) {
                    addBookingMenu();
                } else if (option == 12) {
                    cancelBookingMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException _) {
                System.out.println("Input must be integer");
                sc.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    // Guests related methods
    public void getAllGuestsMenu() {
        String response = guestController.getAllGuests();
        System.out.println(response);
    }
    public void getGuestByIdMenu() {
        System.out.println("Please enter id");

        int id = sc.nextInt();
        String response = guestController.getGuest(id);
        System.out.println(response);
    }
    public void createGuestMenu() {
        System.out.println("Please enter name");
        String name = sc.next();
        System.out.println("Please enter surname");
        String surname = sc.next();
        System.out.println("Please enter age");
        int age = sc.nextInt();
        System.out.println("Please enter gender (male/female)");
        String gender = sc.next();

        String response = guestController.registerGuest(name, surname, age, gender);
        System.out.println(response);
    }

    public void removeGuestMenu() {
        System.out.println("Enter guest's id");
        int id = sc.nextInt();
        String response = guestController.removeGuest(id);
        System.out.println(response);
    }

    // Room related methods
    public void getAllRoomsMenu() {
        String response = roomController.getAllRooms();
        System.out.println(response);
    }
    public void getRoomByIdMenu() {
        System.out.println("Please enter room number");

        int id = sc.nextInt();
        String response = roomController.getRoom(id);
        System.out.println(response);
    }
    public void getAvailableRoomsMenu() {
        System.out.println("Enter the first date and the second in a 'mm-dd' format");
        System.out.println("First: ");
        String date = sc.next();
        String date1 = "2020-"+date;
        System.out.println("Second: ");
        date = sc.next();
        String date2 = "2020-"+date;


        String response = roomController.getAvailableRooms(date1, date2);
        System.out.println(response);
    }
    public void addRoomMenu() {
        System.out.println("Please enter room number");
        int roomId = sc.nextInt();
        System.out.println("Please enter room type");
        String type = sc.next();
        System.out.println("Please enter number of seats");
        int seats = sc.nextInt();
        System.out.println("Please enter cost per night");
        int cost = sc.nextInt();

        String response = roomController.createRoom(roomId, type, seats, cost);
        System.out.println(response);
    }

    // Booking related methods
    public void getAllBookingsMenu() {
        String response = bookingController.getAllBookings();
        System.out.println(response);
    }
    public void getBookingByIdMenu() {
        System.out.println("Please enter id of a booking");

        int id = sc.nextInt();
        String response = bookingController.getBooking(id);
        System.out.println(response);
    }
    public void addBookingMenu() {
        System.out.println("Please enter guest's id");
        int guestId = sc.nextInt();
        System.out.println("Please enter number of a room");
        int roomId = sc.nextInt();

        String monthArr;
        int monthNum;
        while (true) {
            System.out.println("Please enter a month of of arrival");
            monthArr = sc.next();
            monthArr = monthArr.toUpperCase(Locale.ROOT);
            if (monthArr.equals("JANUARY")) {
                monthNum = 1;
                break;
            } else if (monthArr.equals("FEBRUARY")) {
                monthNum = 2;
                break;
            } else if (monthArr.equals("MARCH")) {
                monthNum = 3;
                break;
            } else if (monthArr.equals("APRIL")) {
                monthNum = 4;
                break;
            } else if (monthArr.equals("MAY")) {
                monthNum = 5;
                break;
            } else if (monthArr.equals("JUNE")) {
                monthNum = 6;
                break;
            } else if (monthArr.equals("JULY")) {
                monthNum = 7;
                break;
            } else if (monthArr.equals("AUGUST")) {
                monthNum = 8;
                break;
            } else if (monthArr.equals("SEPTEMBER")) {
                monthNum = 9;
                break;
            } else if (monthArr.equals("OCTOBER")) {
                monthNum = 10;
                break;
            } else if (monthArr.equals("NOVEMBER")) {
                monthNum = 11;
                break;
            } else if (monthArr.equals("DECEMBER")) {
                monthNum = 12;
                break;
            } else {
                System.out.println("Invalid monthArr!");
            }
        }

        String dayArr;
        int day;
        while (true) {
            System.out.println("Please enter a day of of arrival");
            day = sc.nextInt();
            if (day >= 1 && day < 10) {
                dayArr = "0" + day;
            } else {
                dayArr = "" + day;
            }
            if ((monthArr.equals("JANUARY") || monthArr.equals("MARCH") || monthArr.equals("MAY") || monthArr.equals("JULY") || monthArr.equals("AUGUST") || monthArr.equals("OCTOBER") || monthArr.equals("DECEMBER") && day >= 1 && day <= 31)) {
                break;
            } else if (monthArr.equals("FEBRUARY") && day >= 1
                    && day <= 28) {
                break;
            } else if (day >= 1 && day <= 30) {
                break;
            }
        }
        Date dateIn = Date.valueOf("2021-" + monthNum + "-" + dayArr);

        String dayOut;
        System.out.println("for how many days?");
        int days = sc.nextInt();
        day += days;
        if ((monthArr.equals("JANUARY") || monthArr.equals("MARCH") || monthArr.equals("MAY") || monthArr.equals("JULY") || monthArr.equals("AUGUST") || monthArr.equals("OCTOBER") || monthArr.equals("DECEMBER")) && day > 31) {
            day -= 31;
            monthNum += 1;
        } else if (monthArr.equals("FEBRUARY") && day > 28) {
            day -= 28;
            monthNum += 1;
        } else if (day > 30) {
            day -= 30;
            monthNum += 1;
        }
        if (day >= 1 && day < 10) {
            dayOut = "0" + day;
        } else {
            dayOut = "" + day;
        }

        Date dateOut = Date.valueOf("2021-" + monthNum + "-" + dayOut);

        System.out.println("Please enter some description(optional)");
        String description = sc.nextLine();
        String response = bookingController.createBooking(guestId, roomId, dateIn, dateOut, description);
        System.out.println(response);
    }

    public void cancelBookingMenu() {
        System.out.println("Enter id of a booking");
        int id = sc.nextInt();

        String response = bookingController.cancelBooking(id);
        System.out.println(response);

    }
}



/*

(about repositories)
https://gist.github.com/maestrow/594fd9aee859c809b043


 */