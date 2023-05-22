package com.solvd.hospital.health;
import com.solvd.hospital.people.Doctor;

public class Treatment {
    private String treatmentName;

    public Treatment(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String TreatmentName) {
        this.treatmentName = treatmentName;
    }

    public void recommendTreatment(Doctor doctor) {
        System.out.println("Treatment: " + treatmentName);
    }
}