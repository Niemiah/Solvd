package com.solvd.hospital.functional.interfaces;
import com.solvd.hospital.exceptions.InvalidGenderException;
import com.solvd.hospital.exceptions.InvalidInputException;

@FunctionalInterface
public interface InputValidator {
    void validate(String input) throws InvalidInputException, InvalidGenderException;
}
