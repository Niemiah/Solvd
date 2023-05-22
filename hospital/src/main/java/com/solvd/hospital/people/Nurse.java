package com.solvd.hospital.people;
import com.solvd.hospital.health.CheckVitals;
import com.solvd.hospital.health.NewBed;
import com.solvd.hospital.exceptions.InvalidGenderException;
import com.solvd.hospital.exceptions.InvalidBedException;

public class Nurse extends Employee implements CheckVitals, NewBed {

    public Nurse(String fullName, String gender, int age, int id, String departmentName, String experience) throws InvalidGenderException {
        super(fullName, gender, age, id, departmentName, experience);
    }

    @Override public String toString() {
        return "Nurse: " + '\n' +
                "fullName: " + getFullName() + '\n' +
                "gender: " + getGender() + '\n' +
                "age: " + getAge() + '\n' +
                "id: " + getId() + '\n' +
                "departmentName: " + getDepartmentName() + '\n' +
                "experience: " + getExperience() + '\n'
                ;
    }

    @Override
    public void checkVitals(Nurse nurse) {
        System.out.println("Nurse " + nurse.getFullName() + " " + " is checking vitals.");
    }

    @Override
    public void prepBed(Nurse nurse) throws InvalidBedException {
        System.out.println("Nurse " + nurse.getFullName() + " " + " will prep the bed.");
        boolean isBedClean = true; // replace with code to check if bed is clean
        if (!isBedClean) {
            throw new InvalidBedException("Bed is not ready. It needs to be cleaned first.");
        }
    }
}