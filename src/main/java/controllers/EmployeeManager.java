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

    public void addEmployee(String name) {
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
    public void removeEmployee(String id) {
        String tempFile = "src/main/resources/temp.txt";
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
}
