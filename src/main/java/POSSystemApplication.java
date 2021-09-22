import controllers.EmployeeManager;
import controllers.ItemManager;
import models.Employee;
import models.Item;

import java.util.HashMap;
import java.util.Map;

public class POSSystemApplication {

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.newEmployee("1255","James");

        System.out.print("Yes");
    }
}
