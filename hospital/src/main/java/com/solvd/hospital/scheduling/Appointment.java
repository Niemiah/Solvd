package com.solvd.hospital.scheduling;
import com.solvd.hospital.exceptions.InvalidAppointmentException;

public class Appointment {
    private String date;
    private String time;
    private String roomNumber;
    private String roomType;

    public Appointment(String date, String time, String roomNumber, String roomType) throws InvalidAppointmentException {
        this.date = date;
        setTime(time);
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) throws InvalidAppointmentException {
        if (time.length() > 10) {
            throw new InvalidAppointmentException("Appointment time is too long.");
        } else {
            this.time = time;
        }
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Appointment: " + '\n' +
                "date: " + getDate() + '\n' +
                "time: " + getTime() + '\n' +
                "roomNumber: " + getRoomNumber() + '\n' +
                "roomType: " + getRoomType() + '\n'
                ;
    }
}
