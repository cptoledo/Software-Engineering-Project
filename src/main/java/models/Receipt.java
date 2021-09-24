package models;

public class Receipt {

    private String time;
    private String customer;
    private String cashier;
    private ItemOrder[] items;
    private int price;
    private int salesTax;
    private int total;

    /**
     * Construct a Receipt object to store information pertaining to the pizza shop order.
     * @param time          The time the order was processed.
     * @param customer      The customer name on the order.
     * @param cashier       The cashier who processed the order.
     * @param price         The price of the order.
     * @param salesTax      The tax of the order.
     * @param total         The total price of the order.
     */
    public Receipt(
            String time,
            String customer,
            String cashier,
            ItemOrder[] items,
            int price,
            int salesTax,
            int total) {
        this.time = time;
        this.customer = customer;
        this.cashier = cashier;
        this.items = items;
        this.price = price;
        this.salesTax = salesTax;
        this.total = total;
    }

    /**
     * Get the time.
     * @return The time.
     */
    public String getTime() {
        return time;
    }

    /**
     * Set the time.
     * @param time A time.
     */
    private void setTime(String time) {
        this.time = time;
    }

    /**
     * Get the customer name.
     * @return The customer name.
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Set the customer name.
     * @param customer A customer name.
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * Get the cashier name.
     * @return The cashier name.
     */
    public String getCashier() {
        return cashier;
    }

    /**
     * Set the cashier name.
     * @param cashier A cashier name.
     */
    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    /**
     * Get the array of items.
     * @return The array of items.
     */
    public ItemOrder[] getItems() {
        return items;
    }

    /**
     * Set the array of items.
     * @param items An array of items.
     */
    public void setItems(ItemOrder[] items) {
        this.items = items;
    }

    /**
     * Get the price of the order.
     * @return The price of the order.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price of the order.
     * @param price A price of the order.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get the tax of the price of the order.
     * @return The tax of the price of the order.
     */
    public int getSalesTax() {
        return salesTax;
    }

    /**
     * Set the tax of the price of the order.
     * @param salesTax A tax of the price of the order.
     */
    public void setSalesTax(int salesTax) {
        this.salesTax = salesTax;
    }

    /**
     * Get the total price of the order.
     * @return The total price of the order.
     */
    public int getTotal() {
        return total;
    }

    /**
     * Set the total price of the order.
     * @param total A total price of the order.
     */
    public void setTotal(int total) {
        this.total = total;
    }

    public String toString() {
        return "Receipt{" +
                "customer='" + customer + '\'' +
                ", cashier='" + cashier + '\'' +
                ", price=" + price +
                ", salesTax=" + salesTax +
                ", total=" + total +
                '}';
    }
}
