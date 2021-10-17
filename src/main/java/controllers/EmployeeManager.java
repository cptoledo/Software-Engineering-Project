package controllers;

import models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {

    private HashMap<String, Employee> employeeMap;
    private List<String> ids;

    public EmployeeManager() {
        this.employeeMap = getEmployees();
    }

    public HashMap<String, Employee> getEmployees() {
        HashMap<String, Employee> employeeMap = new HashMap<>();
        List<String> ids = new ArrayList<>();

        File file = new File("src/main/resources/employeedata.txt");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                Employee employee = new Employee();
                employee.setId(dataSplit[0]);
                employee.setName(dataSplit[1]);

                employeeMap.put(employee.getId(), employee);
                ids.add(employee.getId());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.employeeMap = employeeMap;
        this.ids = ids;

        return this.employeeMap;
    }

    // TODO: Set max employees to 20.
    // TODO: PIN should be created by user, not randomly generated.

    /**
     * Method to add an employee to the system.
     * @param name  An employee name.
     * @param id    An employee PIN/ID.
     */
    public void addEmployee(String name, String id) {
        boolean duplicate = true;
        while (duplicate) {
            for (String searchId : this.ids) {
                if (id.equals(searchId)) {
                    // TODO: Reprompt user to enter another PIN.
                    //id = String.format("%04d", (int) (Math.random() * 9999));
                } else {
                    duplicate = false;
                }
            }
        }
        String newEmployee = "\n" + id + "," + name;
        Employee employee = new Employee(id, name);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/employeedata.txt", true));
            writer.append(newEmployee);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        employeeMap.put(id, employee);
        ids.add(id);
    }

    //TODO if employee id does not exist

    /**
     * Method to remove an employee from the system.
     * @param id A search PIN/ID.
     */
    public void removeEmployee(String id) {
        String tempFile = "src/main/resources/tempemployeedata.txt";
        File oldFile = new File("src/main/resources/employeedata.txt");
        File newFile = new File(tempFile);

        try {
            Scanner scanner = new Scanner(oldFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            int numRecords = 0;
            boolean match = false;
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                if (!id.equals(dataSplit[0])) {
                    writer.append(data).append("\n");
                    match = true;
                }
                numRecords++;
            }
            scanner.close();
            writer.close();

            if (numRecords > 1) {
                if (match) {
                    oldFile.delete();
                    File dump = new File("src/main/resources/employeedata.txt");
                    newFile.renameTo(dump);

                    this.employeeMap = getEmployees();
                } else {
                    //TODO if employee id does not exist.
                }
            } else {
                newFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to change an employee's name.
     * @param id        A search PIN/ID.
     * @param newName   A name.
     */
    public void changeName(String id, String newName) {
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
                    writer.append(dataSplit[0]).append(",").append(newName).append("\n");
                    match = true;
                } else {
                    writer.append(data);
                }
            }
            scanner.close();
            writer.close();

            if (match) {
                oldFile.delete();
                File dump = new File("src/main/resources/employeedata.txt");
                newFile.renameTo(dump);

                this.employeeMap = getEmployees();
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
    public void changeId(String id, String newId) {
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
                    writer.append(newId).append(",").append(dataSplit[1]).append("\n");
                    match = true;
                } else {
                    writer.append(data);
                }
            }
            scanner.close();
            writer.close();

            if (match) {
                oldFile.delete();
                File dump = new File("src/main/resources/employeedata.txt");
                newFile.renameTo(dump);

                this.employeeMap = getEmployees();
            } else {
                newFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
