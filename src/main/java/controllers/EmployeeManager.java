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
        HashMap<String, Employee> employeeMap = new HashMap<>();
        ids = new ArrayList<>();

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
                ids.add(employee.getId());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.employeeMap = employeeMap;
    }

    public HashMap<String, Employee> getEmployees() {
        return employeeMap;
    }

    public void addEmployee(String name) {
        List<String> ids = new ArrayList<>();
        String id = String.format("%04d", (int) (Math.random() * 9999));

        boolean duplicate = true;
        while (duplicate) {
            for (String searchId : this.ids) {
                if (id.equals(searchId)) {
                    id = String.format("%04d", (int) (Math.random() * 9999));
                } else {
                    duplicate = false;
                }
            }
        }

        String newEmployee = "\n" + id + "," + name;
        Employee employee = new Employee(id, name);

        modifyDataFile(newEmployee);
        employeeMap.put(id, employee);
        for (String searchId : employeeMap.keySet()) {
            ids.add(searchId);
        }
        this.ids = ids;
    }

    public void removeEmployee(String id) {
        HashMap newEmployeeMap = new HashMap<>();

        int index = 0;
        try {
            File file = new File("employeedata.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                if (id.equals(dataSplit[0])) {
                    modifyDataFile("");
                    newEmployeeMap = getEmployees();
                    ids.remove(index);
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.employeeMap = newEmployeeMap;
    }

    private void modifyDataFile(String line) {
        try {
            File file = new File("employeedata.txt");
            PrintWriter printWriter = new PrintWriter(file);
            BufferedWriter writer = new BufferedWriter(new FileWriter("employeedata.txt", true));
            //clear file
            printWriter.write("");

            // Rewrite the file.
            for (String key : employeeMap.keySet()) {
                writer.append(key + "," + employeeMap.get(key).toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
