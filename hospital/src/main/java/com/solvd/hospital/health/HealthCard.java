package com.solvd.hospital.health;

public class HealthCard {
    private String conditionName;
    private String conditionName2;
    private String previousSurgeries;
    private String allergies;

    public HealthCard(String conditionName, String conditionName2, String previousSurgeries, String allergies) {
        this.conditionName = conditionName;
        this.conditionName2 = conditionName2;
        this.previousSurgeries = previousSurgeries;
        this.allergies = allergies;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionName2() {
        return conditionName2;
    }

    public void setConditionName2(String conditionName2) {
        this.conditionName2 = conditionName2;
    }

    public String getPreviousSurgeries() {
        return previousSurgeries;
    }

    public void setPreviousSurgeries(String previousSurgeries) {
        this.previousSurgeries = previousSurgeries;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "HealthCard{" +
                "conditionName='" + conditionName + '\'' +
                ", conditionName2='" + conditionName2 + '\'' +
                ", previousSurgeries='" + previousSurgeries + '\'' +
                ", allergies='" + allergies + '\'' +
                '}';
    }

}