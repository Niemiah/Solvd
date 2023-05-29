package com.solvd.hospital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Hospital {
    private String name;
    private String phoneNumber;
    private String address;

    private static final Logger logger = LogManager.getLogger(Hospital.class);
    private static Scanner scanner = new Scanner(System.in);
    public Hospital(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hospital: " + name + '\n' +
                "address: " + address + '\n' +
                "phoneNumber: " + phoneNumber + '\n'
                ;
    }
}
