import controllers.EmployeeManager;
import controllers.ItemManager;
import interfaces.LoginInterface;
import models.Employee;
import models.Item;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class POSSystemApplication {

    public static void main(String[] args) {
        //LoginInterface loginInterface = new LoginInterface();

        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.removeEmployee("6681");
        System.out.print(employeeManager.getEmployees());
    }
}
