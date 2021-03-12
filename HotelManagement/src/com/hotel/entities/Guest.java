package com.hotel.entities;

public class Guest{
    private int guestId;
    private String name;
    private String surname;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Guest(int guestId, String name, String surname, int age, String gender) {
        this.guestId = guestId;
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
    }
    public Guest(String name, String surname, int age, String gender) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    @Override
    public String toString() {
        return "Guest's id: " + guestId + '\n' +
               "Name: " + getName() + '\n' +
               "Surname: " + getSurname() + '\n' +
               "Age: " + getAge() + '\n' +
               "Gender: " + getGender() + '\n' + '\n';
    }
}

