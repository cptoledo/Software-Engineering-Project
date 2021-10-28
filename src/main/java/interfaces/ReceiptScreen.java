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

    // TODO: Print cashier and customer name.
    public ReceiptScreen() {
        setContentPane(mainPanel);
        setSize(500, 750);
        setVisible(true);

        cashier.setText("Cashier: " + MainScreen.currentEmployee.getFirstName());
        date.setText("Date: " + TimeUtils.getTimeString("MM/d/yyyy"));
        time.setText("Time: " + TimeUtils.getTimeString("h:mm:ss a"));
        customer.setText("");

        ordersString = "<html>";
        pricesString = "<html>";
        for (ItemOrder itemOrder : CheckoutCart.getCart()) {
            ordersString += itemOrder.getNumItems() + " " + itemOrder.getDescription() + "<br/>";
            pricesString += String.format("%.2f", itemOrder.getPrice()) + "<br/>";
            subtotal += itemOrder.getPrice();
        }
        ordersString += "</html>";
        pricesString += "</html>";

        orders.setText(ordersString);
        prices.setText(pricesString);

        totalsLabel.setText(
                "<html>Sub-total:<br/>" +
                "Total Tax:<br/>" +
                "Total:</html>");

        totalTax = subtotal * ItemManager.getItems().get(0).getPrice();
        total = subtotal + totalTax;

        String subtotalString = String.format("%.2f", subtotal);
        String totalTaxString = String.format("%.2f", totalTax);
        String totalString = String.format("%.2f", total);

        totals.setText(
                "<html>" + subtotalString + "<br/>" +
                totalTaxString + "<br/>" +
                totalString + "</html>");
    }
}
