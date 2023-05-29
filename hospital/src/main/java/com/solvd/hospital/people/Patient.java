package com.solvd.hospital.people;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hospital.health.FindSymptom;
import com.solvd.hospital.health.Symptom;
import com.solvd.hospital.exceptions.InvalidGenderException;

public class Patient extends Person implements FindSymptom {
    private String email;
    private String address;

    private static final Logger LOGGER = LogManager.getLogger(Patient.class);


    public Patient(String fullName, String gender, int age, int id, String email, String address) throws InvalidGenderException {
        super(fullName, gender, age, id);
        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length() > 30) {
            LOGGER.error("No more than 30 characters can be used.");
            return;
        }
        this.address = address;
    }

    public String toString() {
        return "Patient: " + '\n' +
                "fullName: " + getFullName() + '\n' +
                "gender: " + getGender() + '\n' +
                "age: " + getAge() + '\n' +
                "id: " + getId() + '\n' +
                "email: " + getEmail() + '\n' +
                "address: " + getAddress()
                ;
    }

    @Override
    public void giveSymptom(Patient patient, Symptom symptom) {
        System.out.println("Patient " + patient.getFullName() + "has symptom:" +  symptom.getSymptomName());
    }
}