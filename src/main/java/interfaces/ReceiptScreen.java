package interfaces;

import controllers.CheckoutCart;
import controllers.ItemManager;
import models.ItemOrder;
import models.Transaction;
import util.TimeUtils;

import javax.swing.*;
import java.util.ArrayList;

public class ReceiptScreen extends JFrame {

    private JPanel mainPanel;

    private JLabel shopInfo;

    private JLabel cashier;
    private JLabel time;
    private JLabel date;
    private JLabel customer;

    private JLabel orders;
    private JLabel prices;

    private JLabel totals;
    private JLabel totalsLabel;

    private String ordersString;
    private String pricesString;

    private double subtotal = 0;
    private double totalTax;
    private double total;

    private Transaction transaction;

    public ReceiptScreen() {
        setContentPane(mainPanel);
        setSize(500, 750);
        setVisible(true);

        transaction = new Transaction(
                TimeUtils.getTimeString("MM/d/yyyy"),
                TimeUtils.getTimeString("h:mm:ss a"),
                "",
                MainScreen.currentEmployee.getFirstName(),
                CheckoutCart.getCart(),
                subtotal,
                totalTax,
                total);

        ordersString = "<html>";
        pricesString = "<html>";
        for (ItemOrder itemOrder : transaction.getItems()) {
            ordersString += itemOrder.getNumItems() + " " + itemOrder.getDescription() + "<br/>";
            pricesString += String.format("%.2f", itemOrder.getPrice()) + "<br/>";
            subtotal += itemOrder.getPrice();
        }
        ordersString += "</html>";
        pricesString += "</html>";

        totalTax = subtotal * ItemManager.getItems().get(0).getPrice();
        total = subtotal + totalTax;

        transaction.setSubtotal(subtotal);
        transaction.setSalesTax(totalTax);
        transaction.setTotal(total);

        date.setText("Date: " + transaction.getDate());
        time.setText("Time: " + transaction.getTime());
        customer.setText("Customer: " + transaction.getCustomer());
        cashier.setText("Cashier: " + transaction.getCashier());
        orders.setText(ordersString);
        prices.setText(pricesString);
        totalsLabel.setText(
                "<html>Sub-total:<br/>" +
                "Total Tax:<br/>" +
                "Total:</html>");
        String subtotalString = String.format("%.2f", transaction.getSubtotal());
        String totalTaxString = String.format("%.2f", transaction.getSalesTax());
        String totalString = String.format("%.2f", transaction.getTotal());
        totals.setText(
                "<html>" + subtotalString + "<br/>" +
                totalTaxString + "<br/>" +
                totalString + "</html>");

    }
}
