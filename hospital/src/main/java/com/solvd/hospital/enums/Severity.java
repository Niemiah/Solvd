package com.solvd.hospital.enums;
import java.util.HashMap;
import java.util.Map;
public enum Severity {
    LOW(0),
    MEDIUM(1),
    HIGH(2),
    CRITICAL(3),
    BLOCKER(4);

    private int level;

    Severity(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
