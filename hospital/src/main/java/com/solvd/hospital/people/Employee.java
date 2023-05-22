package com.solvd.hospital.people;
import com.solvd.hospital.exceptions.InvalidGenderException;
public class Employee extends Person {
    private String departmentName;
    private String experience;

    public Employee(String fullName, String gender, int age, int id, String departmentName, String experience) throws InvalidGenderException {
        super(fullName, gender, age, id);
        this.departmentName = departmentName;
        this.experience = experience;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override public String toString() {
        return "Employee: " + '\n' +
                "fullName: " + getFullName() + '\n' +
                "gender: " + getGender() + '\n' +
                "age: " + getAge() + '\n' +
                "id: " + getId() + '\n' +
                "departmentName: " + getDepartmentName() + '\n' +
                "experience: " + getExperience() + '\n'
                ;
    }
}
