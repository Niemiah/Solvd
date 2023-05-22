package com.solvd.hospital.functional.interfaces;
import java.io.IOException;
@FunctionalInterface
public interface HealthCareAssistant {
    void performAction(Object person, String action) throws IOException;
}
