package models;

public class ItemOrder {

    private String id;
    private int numItems;
    private int price;

    /**
     * Construct an ItemOrder object to store information about the object.
     * @param id            The ID.
     * @param numItems      The number of items.
     * @param price         The price.
     */
    public ItemOrder(String id, int numItems, int price) {
        this.id = id;
        this.numItems = numItems;
        this.price = price;
    }

    /**
     * Get the ID.
     * @return The ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID.
     * @param id An ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the number of items.
     * @return The number of items.
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     * Set the number of items.
     * @param numItems A number of items
     */
    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    /**
     * Get the price.
     * @return The price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price.
     * @param price A price.
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
