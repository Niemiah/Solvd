package com.solvd.hospital.health;
import com.solvd.hospital.people.Nurse;
import com.solvd.hospital.exceptions.InvalidBedException;
public interface NewBed {
    public void prepBed(Nurse nurse) throws InvalidBedException;
}
