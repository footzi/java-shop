package com.java_shop.Client;

public class Client {
    int id;
    String name;
    String surname;
    String address;
    String phone;

    public Client(int id, String name, String surname, String address, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
