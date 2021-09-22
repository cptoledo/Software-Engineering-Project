package models;

public class Employee {

    private String id;
    private String name;

    /**
     * Get the ID of the employee.
     * @return The ID of the employee.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of the employee.
     * @param id An ID of the employee.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name of the employee.
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the nme of the employee.
     * @param name A name of a employee.
     */
    public void setName(String name) {
        this.name = name;
    }
}
