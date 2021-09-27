import controllers.EmployeeManager;
import interfaces.LoginInterface;

public class POSSystemApplication {

    public static void main(String[] args) {
        //LoginInterface loginInterface = new LoginInterface();


        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.addEmployee("Jacob");
        //employeeManager.removeEmployee("2082");
        System.out.print(employeeManager.getEmployees());

    }
}
