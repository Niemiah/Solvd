package com.solvd.hospital.people;
import com.solvd.hospital.exceptions.InvalidGenderException;
import com.solvd.hospital.exceptions.InvalidAgeException;

public abstract class Person {
    private String fullName;
    private String gender;
    private int age;
    private int id;

    public Person() {
        super();
    }

    public Person(String fullName, String gender, int age, int id) throws InvalidGenderException {
        this.fullName = fullName;
        setGender(gender);
        this.age = age;
        this.id = id;
    }

    // Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws InvalidGenderException {
        if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
            this.gender = gender.toUpperCase();
        } else {
            throw new InvalidGenderException("Invalid gender.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 100) {
            this.age = age;
        } else {
            throw new InvalidAgeException("Age cannot be greater than 100.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName:" + getFullName() + '\'' +
                "gender: " + getGender() + '\'' +
                "age: " + getAge() + '\'' + "id: " + getId()
                ;
    }
}