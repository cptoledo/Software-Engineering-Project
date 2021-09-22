package controllers;

import models.Employee;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeManager {

    private HashMap<String, Employee> employeeMap = new HashMap<>();

    public HashMap<String, Employee> getEmployees() {
        HashMap<String, Employee> employeeMap = new HashMap<>();

        File file = new File("employeedata.txt");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                Employee employee = new Employee();
                employee.setId(dataSplit[0]);
                employee.setName(dataSplit[1]);

                employeeMap.put(employee.getId(), employee);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.employeeMap = employeeMap;
        return this.employeeMap;
    }

    public void newEmployee(String id, String name) {
        String newEmployee = "\n" + id + "," + name;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("employeedata.txt", true));
            writer.append(newEmployee);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
