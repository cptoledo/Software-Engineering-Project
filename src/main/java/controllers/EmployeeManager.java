package controllers;

import interfaces.MainScreen;
import models.Employee;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeManager {

    public static HashMap<String, Employee> getEmployees() {
        HashMap<String, Employee> employeeMap = new HashMap<>();

        File file = new File("src/main/resources/employeedata.txt");

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
        String newEmployee;

        // Check there are already 20 employees on the system.
        if (getEmployees().size() < 20) {
            // Check if there is an already existing id in the system.
            if (!getEmployees().containsKey(id)) {
                newEmployee = id + "," + lastName + "," + firstName + "\n";

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
        String tempFile = "src/main/resources/tempemployeedata.txt";
        File oldFile = new File("src/main/resources/employeedata.txt");
        File newFile = new File(tempFile);

        try {
            Scanner scanner = new Scanner(oldFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            int numRecords = getEmployees().size();
            boolean match = false;
            // Check if there is only 1 employee left in the system.
            // Check if employee to be deleted is the current user.
            if (numRecords > 1 && !id.equals(MainScreen.currentEmployee.getId())) {
                while (scanner.hasNext()) {
                    String data = scanner.nextLine();
                    String[] dataSplit = data.split(",");

                    if (!id.equals(dataSplit[0])) {
                        writer.append(data).append("\n");
                    } else {
                        match = true;
                    }
                }
                scanner.close();
                writer.close();

                if (match) {
                    oldFile.delete();
                    File dump = new File("src/main/resources/employeedata.txt");
                    newFile.renameTo(dump);
                } else {
                    newFile.delete();
                }
            }
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
        String tempFile = "src/main/resources/tempemployeedata.txt";
        File oldFile = new File("src/main/resources/employeedata.txt");
        File newFile = new File(tempFile);

        try {
            Scanner scanner = new Scanner(oldFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            boolean match = false;
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                if (id.equals(dataSplit[0])) {
                    writer.append(dataSplit[0]).append(",").append(lastName).append(",").append(firstName).append("\n");
                    match = true;
                } else {
                    writer.append(data).append("\n");
                }
            }
            scanner.close();
            writer.close();

            if (match) {
                oldFile.delete();
                File dump = new File("src/main/resources/employeedata.txt");
                newFile.renameTo(dump);
            } else {
                newFile.delete();
            }
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
        String tempFile = "src/main/resources/tempemployeedata.txt";
        File oldFile = new File("src/main/resources/employeedata.txt");
        File newFile = new File(tempFile);

        try {
            Scanner scanner = new Scanner(oldFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            boolean match = false;
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                if (id.equals(dataSplit[0])) {
                    writer.append(newId).append(",").append(dataSplit[1]).append(",").append(dataSplit[2]).append("\n");
                    match = true;
                } else {
                    writer.append(data).append("\n");
                }
            }
            scanner.close();
            writer.close();

            if (match) {
                oldFile.delete();
                File dump = new File("src/main/resources/employeedata.txt");
                newFile.renameTo(dump);
            } else {
                newFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
