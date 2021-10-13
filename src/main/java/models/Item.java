package models;

public class Item {

    private int id;
    private String description;
    private double price;

    /**
     * Construct an Item object to store information pertaining to the item.
     * @param id            The ID of the item.
     * @param description   The description of the item.
     * @param price         The price of the item.
     */
    public Item(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    /**
     * Construct an empty Item object.
     */
    public Item() {
        this.id = 0;
        this.description = "";
        this.price = 0;
    }

    /**
     * Get the ID.
     * @return The ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID.
     * @param id An ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Get the price.
     * @return The price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price.
     * @param price A price.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
