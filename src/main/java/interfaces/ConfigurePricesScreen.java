package interfaces;

import controllers.ItemManager;
import models.Item;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

public class ConfigurePricesScreen extends JPanel {

    private JPanel mainPanel;
    private JList pizzaList;
    private JTextField priceField;
    private JLabel label;
    private JButton confirmButton;

    private int itemId;
    private double newPrice;

    public ConfigurePricesScreen() {
        add(mainPanel);
        setVisible(true);

        pizzaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pizzaList.addListSelectionListener(e -> {
            priceField.setEnabled(true);
            if (pizzaList.isSelectedIndex(0)) {
                itemId = 1;
            } else if (pizzaList.isSelectedIndex(1)) {
                itemId = 2;
            } else if (pizzaList.isSelectedIndex(2)) {
                itemId = 11;
            } else if (pizzaList.isSelectedIndex(3)) {
                itemId = 12;
            } else if (pizzaList.isSelectedIndex(4)) {
                itemId = 21;
            } else if (pizzaList.isSelectedIndex(5)) {
                itemId = 22;
            } else if (pizzaList.isSelectedIndex(6)) {
                itemId = 31;
            } else if (pizzaList.isSelectedIndex(7)) {
                itemId = 0;
            }
        });

        priceField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String value = priceField.getText();

                try {
                    newPrice = Double.parseDouble(value);
                    label.setText("");
                    confirmButton.setEnabled(true);
                } catch (Exception ex) {
                    label.setText("Enter valid input (eg. 5.99)");
                    confirmButton.setEnabled(false);
                }
            }
        });

        confirmButton.addActionListener(e -> {
            // Format new price to 2 decimal places
            DecimalFormat df = new DecimalFormat("#.00");
            newPrice = Double.parseDouble(df.format(newPrice));

            if (itemId == 31) {
                // Soda prices
                ItemManager.setPrice(31, newPrice);
                ItemManager.setPrice(32, newPrice);
            } else if (itemId % 10 == 2) {
                // Topping pizza prices
                for (int i = itemId; i <= itemId + 7; i++) {
                    ItemManager.setPrice(i, newPrice);
                }
            } else {
                // Tax and no-topping pizza prices
                ItemManager.setPrice(itemId, newPrice);
            }
        });
    }
}
