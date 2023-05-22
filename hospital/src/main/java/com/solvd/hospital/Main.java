package com.solvd.hospital;
import com.solvd.hospital.exceptions.InvalidAgeException;
import com.solvd.hospital.functional.interfaces.InputValidator;
import com.solvd.hospital.health.Diagnosis;
import com.solvd.hospital.health.Symptom;
import com.solvd.hospital.health.Treatment;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.solvd.hospital.exceptions.InvalidGenderException;
import com.solvd.hospital.exceptions.InvalidInputException;
import com.solvd.hospital.exceptions.InvalidAppointmentException;
import com.solvd.hospital.people.Doctor;
import com.solvd.hospital.people.Patient;
import com.solvd.hospital.people.FrontDeskWorker;
import com.solvd.hospital.people.Nurse;
import com.solvd.hospital.scheduling.Appointment;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;
import com.solvd.hospital.functional.interfaces.IntPredicate;
import com.solvd.hospital.functional.interfaces.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InvalidInputException, InvalidGenderException, InvalidAppointmentException, IOException, ClassNotFoundException {
        LOGGER.info("Creating Hospital object");
        Hospital hospital1 = new Hospital("St. Mary's", "5946 Wallaby Way", "123-456-7890");
        LOGGER.info("Creating Patient object");
        Patient patient2 = new Patient("Tony Jones", "M", 26, 1, "Limitless@gmail.com", "1234 Main St");
        Appointment appointment1 = new Appointment("2023-07-04", "09:00", "A101", "Standard");
        Appointment appointment2 = new Appointment("2023-06-25", "03:30", "A102", "Standard");
        Appointment appointment3 = new Appointment("2023-05-10", "10:00", "A103", "Standard");
        Appointment appointment4 = new Appointment("2023-05-17", "02:00", "A104", "Standard");
        FrontDeskWorker frontDeskWorker1 = new FrontDeskWorker("Sally Smith", "F", 25, 1, "Front Desk", "2 years");
        FrontDeskWorker frontDeskWorker2 = new FrontDeskWorker("Sam Smith", "M", 27, 2, "Front Desk", "3 years");
        Nurse nurse1 = new Nurse("Nancy Drew", "F", 30, 1, "Nursing", "5 years");
        Nurse nurse2 = new Nurse("Ned Nickelson", "M", 32, 2, "Nursing", "7 years");
        Doctor doctor1 = new Doctor("John Doe", "M", 55, 2, "Cardiology", "5 years");
        Doctor doctor2 = new Doctor("Jane Doe", "F", 58, 1, "Radiology", "10 years");
        Doctor doctor3 = new Doctor("David Los", "M", 60, 3, "Neurology", "9 years");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reflection to get the methods of the Doctor class
        Class<?> doctorClass = Class.forName("com.solvd.hospital.people.Doctor");
        Method[] methods = doctorClass.getDeclaredMethods();
        LOGGER.info("Methods in Doctor class:");
        for (Method method : methods) {
            LOGGER.info(method.getName());
        }

        System.out.println(hospital1.toString());


        LOGGER.info("Enter patient's full name: ");
        String fullName = reader.readLine();

        IntConsumer validAge = age -> {
            if (age <= 1 || age >= 110) {
                try {
                    throw new InvalidAgeException("Invalid age: " + age);
                } catch (InvalidAgeException e) {
                    LOGGER.info(e.getMessage());
                }
            } else {
                LOGGER.info("Age is valid.");
            }
        };

        int age = 0;
        try {
            LOGGER.info("Enter patient age: ");
            age = Integer.parseInt(reader.readLine());

            validAge.accept(age);
        } catch (IOException e) {
            LOGGER.error("An error occurred while reading input.");
        }

        LOGGER.info("Enter patient gender (M/F/O): ");
        String gender = reader.readLine();

        InputValidator genderValidator = (String genderInput) -> {
            if (!genderInput.equals("M") && !genderInput.equals("F") && !genderInput.equals("O")) {
                throw new InvalidGenderException("Invalid gender input. Must be M, F, or O.");
            }
        };
        genderValidator.validate(gender);

        LOGGER.info("Enter patient ID: ");
        int patientId = Integer.parseInt(reader.readLine());

        IntPredicate isValid = value -> value >= 1 && value <= 10000;
        System.out.println(isValid.test(4));

        LOGGER.info("Enter patient email: ");
        String email = reader.readLine();

        LOGGER.info("Enter patient address: ");
        String address = reader.readLine();

        Patient patient1 = new Patient(fullName, gender, age, patientId, email, address);
        System.out.println(patient1.toString());


        // List of available appointments
        List<Appointment> availableAppointments = new ArrayList<>();
        availableAppointments.add(appointment1);
        availableAppointments.add(appointment2);
        availableAppointments.add(appointment3);
        availableAppointments.add(appointment4);


        // Collect appointments into a List using Collectors.toList()
        List<Appointment> collectedAppointments = availableAppointments.stream()
                .collect(Collectors.toList());

        // Print collected appointments
        LOGGER.info("Available appointments:");
        collectedAppointments.forEach(System.out::println);

        // Prompt the user to select an appointment by entering a number
        LOGGER.info("Select an appointment (enter a number): ");
        int appointmentSelection;
        try {
            appointmentSelection = Integer.parseInt(reader.readLine());
            if (appointmentSelection < 1 || appointmentSelection > collectedAppointments.size()) {
                throw new InvalidInputException("Not a valid input");
            }
        } catch (InvalidInputException e) {
            LOGGER.error("Not a valid input");
            return;
        }

        // Appointment using the selected appointment
        Appointment selectedAppointment = collectedAppointments.get(appointmentSelection - 1);

        // Print the selected appointment details
        LOGGER.info("Selected appointment:");
        System.out.println(selectedAppointment.toString());

        // List of available doctors
        List<Doctor> availableDoctors = new ArrayList<>();
        availableDoctors.add(doctor1);
        availableDoctors.add(doctor2);
        availableDoctors.add(doctor3);

        // Collect Doctors into a List using Collectors.toList()
        List<Doctor> collectedDoctors = availableDoctors.stream()
                .collect(Collectors.toList());

        // Print collected Doctors
        LOGGER.info("Available Doctors:");
        collectedDoctors.forEach(System.out::println);


        // Prompt the user to select a doctor by entering a number
        LOGGER.info("Select a doctor (enter a number): ");
        int doctorSelection;
        try {
            doctorSelection = Integer.parseInt(reader.readLine());
            if (doctorSelection < 1 || doctorSelection > collectedDoctors.size()) {
                throw new InvalidInputException("Not a valid input");
            }
        } catch (InvalidInputException e) {
            LOGGER.error("Not a valid input");
            return;
        }

        // Appointment using the selected doctor and date
        Doctor selectedDoctor = collectedDoctors.get(doctorSelection - 1);
        LOGGER.info("Selected Doctor:");
        System.out.println(selectedDoctor.toString());

        List<Nurse> nurses = new ArrayList<>();
        nurses.add(nurse1);
        nurses.add(nurse2);

        Stream<Nurse> nurseStream = nurses.stream();

        Random rand = new Random();
        int randomIndex = rand.nextInt(nurses.size());
        Nurse randomNurse = nurses.get(randomIndex);
        LOGGER.info("Random Nurse:");
        System.out.println(randomNurse);

        //get patients symptom
        LOGGER.info("Enter your symptom: ");
        String symptom = reader.readLine();
        Symptom patient1Symptom = new Symptom(symptom);
        patient1Symptom.giveSymptom(patient1, patient1Symptom);

        //get patients treatment
        LOGGER.info("Doctors recommended treatment: ");
        String treatment = reader.readLine();
        Treatment patient1Treatment = new Treatment(treatment);
        System.out.println("Your treatment is: " + patient1Treatment.getTreatmentName());

        //get patients diagnosis
        LOGGER.info("Doctors diagnosis: ");
        String diagnosis = reader.readLine();
        Diagnosis patientDiagnosis = new Diagnosis(diagnosis);
        doctor1.giveDiagnosis(doctor1, patientDiagnosis);
    }
}