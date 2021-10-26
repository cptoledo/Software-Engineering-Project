package interfaces;

import controllers.ItemManager;
import models.ItemOrder;
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
    public ReceiptScreen(ArrayList<ItemOrder> cart) {
        setContentPane(mainPanel);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        date.setText("Date: " + TimeUtils.getTimeString("MM/d/yyyy"));
        time.setText("Time: " + TimeUtils.getTimeString("h:mm:ss a"));

        ordersString = "<html>";
        pricesString = "<html>";
        for (ItemOrder itemOrder : cart) {
            ordersString += itemOrder.getNumItems() + " " + itemOrder.getDescription() + "<br/>";
            pricesString += itemOrder.getPrice() + "<br/>";
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

        String totalTaxString = String.format("%.2f", totalTax);
        String totalString = String.format("%.2f", total);

        totals.setText(
                "<html>" + subtotal + "<br/>" +
                totalTaxString + "<br/>" +
                totalString + "</html>");
    }
}
