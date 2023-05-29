package com.solvd.hospital.health;
import com.solvd.hospital.people.Doctor;

public class Diagnosis implements Diagnose{
    public String diagnosisName;

    public Diagnosis(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    @Override
    public void giveDiagnosis(Doctor doctor, Diagnosis diagnosis) {
        System.out.println("The diagnosis is: " + this.diagnosisName);
    }
}