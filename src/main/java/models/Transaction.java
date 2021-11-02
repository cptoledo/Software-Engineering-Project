package models;

import java.util.ArrayList;

public class Transaction {

    private String date;
    private String time;
    private String customer;
    private String cashier;
    private ArrayList<ItemOrder> items;
    private double subtotal;
    private double tax;
    private double total;

    /**
     * Construct a Receipt object to store information pertaining to the pizza shop order.
     * @param date          The date the order was processed.
     * @param time          The time the order was processed.
     * @param customer      The customer name on the order.
     * @param cashier       The cashier who processed the order.
     * @param subtotal      The price (before tax) of the order.
     * @param tax           The tax of the order.
     * @param total         The price (after tax) of the order.
     */
    public Transaction(
            String date,
            String time,
            String customer,
            String cashier,
            ArrayList<ItemOrder> items,
            double subtotal,
            double tax,
            double total) {
        this.date = date;
        this.time = time;
        this.customer = customer;
        this.cashier = cashier;
        this.items = items;
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
    }

    /**
     * Get the date.
     * @return The date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the date.
     * @param date A date.
     */
    public void setDate(String date) {
        this.date = date;
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
     * Get the array list of items.
     * @return The array list of items.
     */
    public ArrayList<ItemOrder> getItems() {
        return items;
    }

    /**
     * Set the array lsit of items.
     * @param items An array list of items.
     */
    public void setItems(ArrayList<ItemOrder> items) {
        this.items = items;
    }

    /**
     * Get the price (before tax) of the order.
     * @return The price (before tax) of the order.
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Set the price (after tax) of the order.
     * @param subtotal A price (after tax) of the order.
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Get the tax of the price of the order.
     * @return The tax of the price of the order.
     */
    public double getSalesTax() {
        return tax;
    }

    /**
     * Set the tax of the price of the order.
     * @param tax A tax of the price of the order.
     */
    public void setSalesTax(double tax) {
        this.tax = tax;
    }

    /**
     * Get the total price of the order.
     * @return The total price of the order.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Set the total price of the order.
     * @param total A total price of the order.
     */
    public void setTotal(double total) {
        this.total = total;
    }
}
