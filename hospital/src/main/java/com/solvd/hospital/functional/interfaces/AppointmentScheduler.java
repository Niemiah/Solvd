package com.solvd.hospital.functional.interfaces;
import com.solvd.hospital.exceptions.InvalidInputException;
import com.solvd.hospital.scheduling.Appointment;
import java.util.List;
@FunctionalInterface
public interface AppointmentScheduler {
    Appointment schedule(List<Appointment> appointments, int selection) throws InvalidInputException;
}

