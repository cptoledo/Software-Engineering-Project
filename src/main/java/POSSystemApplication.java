import controllers.EmployeeManager;
import interfaces.*;

/**
 * THIS IS THE MAIN CLASS! RUN AND TEST ALL MAIN PROGRAMS HERE.
 */
public class POSSystemApplication {

    public static void main(String[] args) {


        //EmployeeManager employeeManager = new EmployeeManager();
        //employeeManager.addEmployee("Jacob");
        //employeeManager.removeEmployee("2082");
        //System.out.print(employeeManager.getEmployees());

        //MainScreen mainScreen = new MainScreen();
        //new LoginScreen();
        new ReceiptScreen(null);
    }
}
