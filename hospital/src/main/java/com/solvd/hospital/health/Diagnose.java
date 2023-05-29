package com.solvd.hospital.health;
import com.solvd.hospital.people.Doctor;

public interface Diagnose {
    public void giveDiagnosis(Doctor doctor, Diagnosis diagnosis);
}
