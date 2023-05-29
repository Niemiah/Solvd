package com.solvd.hospital.enums;
import java.util.HashMap;
import java.util.Map;
public enum Dosage {
    _5MG(0),
    _10MG(1),
    _15MG(2),
    _20MG(3),
    _25MG(4);

    private int value;

    Dosage(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
