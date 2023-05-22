package com.solvd.hospital.enums;
import java.util.HashMap;
import java.util.Map;
public enum LengthOfStay {
    OVER_NIGHT(0),
    TWO_DAYS(1),
    THREE_DAYS(2),
    ONE_WEEK(3),
    TWO_WEEKS(4);
    private int days;

    LengthOfStay(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
