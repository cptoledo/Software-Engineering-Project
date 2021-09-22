package models;

public class ItemOrder {

    private String description;
    private int numItems;
    private double price;

    /**
     * Construct an ItemOrder object to store information pertaining to the item order.
     * @param description   The description of the item order.
     * @param numItems      The number of items in the order.
     * @param price         The price of the items in the order.
     */
    public ItemOrder(String description, int numItems, double price) {
        this.description = description;
        this.numItems = numItems;
        this.price = price;
    }

    /**
     * Get the description of the item.
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the item.
     * @param description A description of the item.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the number of items in the order.
     * @return The number of items in the order.
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     * Set the number of items in the order.
     * @param numItems A number of items in the order.
     */
    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    /**
     * Get the price of the items in the order.
     * @return The price of the items in the order.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the items in the order.
     * @param price A price of the items in the order.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
