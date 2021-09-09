package models;

public class SodaOrder extends ItemOrder {

    private String sodaType;

    /**
     * Construct a SodaOrder object to store information about the soda order.
     * @param sodaType The soda type.
     */
    public SodaOrder(String sodaType, int numSodas, int price) {
        super("2", numSodas, price);
        this.sodaType = sodaType;
    }

    /**
     * Get the soda type.
     * @return The soda type.
     */
    public String getSodaType() {
        return sodaType;
    }

    /**
     * Set the soda type.
     * @param sodaType A soda type.
     */
    public void setSodaType(String sodaType) {
        this.sodaType = sodaType;
    }
}
