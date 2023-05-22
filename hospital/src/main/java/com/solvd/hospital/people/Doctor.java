package com.solvd.hospital.people;
import com.solvd.hospital.health.Diagnosis;
import com.solvd.hospital.health.Diagnose;
import com.solvd.hospital.health.Treat;
import com.solvd.hospital.exceptions.InvalidGenderException;

public class Doctor extends Employee implements Treat, Diagnose {

    public Doctor(String fullName, String gender, int age, int id, String departmentName, String experience) throws InvalidGenderException {
        super(fullName, gender, age, id, departmentName, experience);
    }

    @Override
    public String toString() {
        return "Doctor: " + '\n' +
                "fullName: " + getFullName() + '\n' +
                "gender: " + getGender() + '\n' +
                "age: " + getAge() + '\n' +
                "id: " + getId() + '\n' +
                "departmentName: " + getDepartmentName() + '\n' +
                "experience: " + getExperience() + '\n'
                ;
    }

    @Override
    public void recommendTreatment(Doctor doctor) {
        System.out.println("Doctor " + doctor.getFullName() + " recommends.");
    }

    @Override
    public void giveDiagnosis(Doctor doctor, Diagnosis diagnosis) {
        System.out.println("The diagnosis is: " + diagnosis.getDiagnosisName());
    }
}