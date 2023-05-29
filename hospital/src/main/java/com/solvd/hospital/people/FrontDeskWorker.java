package com.solvd.hospital.people;
import com.solvd.hospital.exceptions.InvalidGenderException;
public class FrontDeskWorker extends Employee {

    public FrontDeskWorker(String fullName, String gender, int age, int id, String departmentName, String experience) throws InvalidGenderException {
        super(fullName, gender, age, id, departmentName, experience);
    }

    @Override public String toString() {
        return "Front Desk: " + '\n' +
                "fullName: " + getFullName() + '\n' +
                "gender: " + getGender() + '\n' +
                "age: " + getAge() + '\n' +
                "id: " + getId() + '\n' +
                "departmentName: " + getDepartmentName() + '\n' +
                "experience: " + getExperience() + '\n'
                ;
    }
}