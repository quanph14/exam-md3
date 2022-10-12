package model;

import java.sql.Date;

public class Student {
    protected int id;
    protected String name;
    protected Date doB;
    protected String Address;
    protected String phoneNumber;
    protected String email;
    protected String classRoom;

    public Student() {
    }

    public Student(int id, String name, Date doB, String address, String phoneNumber, String email, String classRoom) {
        this.id = id;
        this.name = name;
        this.doB = doB;
        Address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
