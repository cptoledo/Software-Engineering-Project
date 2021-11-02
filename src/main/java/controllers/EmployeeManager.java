package controllers;

import interfaces.MainScreen;
import models.Employee;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeManager {

    public static HashMap<String, Employee> getEmployees() {
        File file = new File("src/main/resources/employeedata.txt");
        HashMap<String, Employee> employeeMap = new HashMap<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                Employee employee = new Employee();
                employee.setId(dataSplit[0]);
                employee.setLastName(dataSplit[1]);
                employee.setFirstName(dataSplit[2]);

                employeeMap.put(employee.getId(), employee);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return employeeMap;
    }

    /**
     * Method to add an employee to the system.
     * @param id        An employee PIN/ID.
     * @param firstName A first name.
     * @param lastName  A last name.
     */
    public static void addEmployee(String id, String firstName, String lastName) {
        String newEmployee = id + "," + lastName + "," + firstName + "\n";

        // Check there are already 20 employees on the system.
        if (getEmployees().size() < 20) {
            // Check if there is an already existing id in the system.
            if (!getEmployees().containsKey(id)) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/employeedata.txt", true));
                    writer.append(newEmployee);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method to remove an employee from the system.
     * @param id A search PIN/ID.
     */
    public static void removeEmployee(String id) {
        File file = new File("src/main/resources/employeedata.txt");
        HashMap<String, Employee> employeeMap = getEmployees();

        try {
            // Clear old data in text file.
            PrintWriter pw = new PrintWriter(file);
            pw.write("");
            pw.close();

            // Write new data in text file.
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            // Check if there is only 1 employee left in the system.
            // Check if employee to be deleted is the current user.
            if (employeeMap.size() > 1 && !id.equals(MainScreen.currentEmployee.getId())) {
                for (Employee employee : employeeMap.values()) {
                    String data = employee.getId() + "," + employee.getLastName() + "," + employee.getFirstName();
                    if (!id.equals(employee.getId())) {
                        writer.append(data).append("\n");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to change an employee's name.
     * @param id        A search PIN/ID.
     * @param firstName A first name.
     * @param lastName  A last name.
     */
    public static void changeName(String id, String firstName, String lastName) {
        File file = new File("src/main/resources/employeedata.txt");
        HashMap<String, Employee> employeeMap = getEmployees();

        try {
            // Clear old data in text file.
            PrintWriter pw = new PrintWriter(file);
            pw.write("");
            pw.close();

            // Write new data in text file.
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            for (Employee employee : employeeMap.values()) {
                String data = employee.getId() + "," + employee.getLastName() + "," + employee.getFirstName();
                if (!id.equals(employee.getId())) {
                    writer.append(data).append("\n");
                } else {
                    writer.append(employee.getId()).append(",").append(lastName).append(",").append(firstName).append("\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to change an employee's PIN/ID.
     * @param id    A search PIN/ID.
     * @param newId A PIN/ID.
     */
    public static void changeId(String id, String newId) {
        File file = new File("src/main/resources/employeedata.txt");
        HashMap<String, Employee> employeeMap = getEmployees();

        try {
            // Clear old data in text file.
            PrintWriter pw = new PrintWriter(file);
            pw.write("");
            pw.close();

            // Write new data in text file.
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            for (Employee employee : employeeMap.values()) {
                String data = employee.getId() + "," + employee.getLastName() + "," + employee.getFirstName();
                if (!id.equals(employee.getId())) {
                    writer.append(data).append("\n");
                } else {
                    writer.append(newId).append(",").append(employee.getLastName()).append(",").append(employee.getFirstName()).append("\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
