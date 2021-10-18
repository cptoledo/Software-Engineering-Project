package models;

public class Employee {

    private String id;
    private String firstName;
    private String lastName;

    public Employee(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee() {
        this.id = "";
        this.firstName = "";
        this.lastName = "";
    }

    /**
     * Get the ID of the employee.
     * @return The ID of the employee.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of the employee.
     * @param id An ID of an employee.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name of the employee.
     * @return The name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the employee.
     * @param firstName A first name of an employee.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the employee.
     * @return The last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the employee.
     * @param lastName A last name of an employee.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
