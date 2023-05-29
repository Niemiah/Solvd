package com.solvd.hospital.health;
import com.solvd.hospital.people.Patient;

public class Symptom implements FindSymptom{
    private String symptomName;

    public Symptom(String symptomName) {
        this.symptomName = symptomName;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public void giveSymptom(Patient patient, Symptom symptom) {
        System.out.println ("Symptom: " + symptomName);
    }
}