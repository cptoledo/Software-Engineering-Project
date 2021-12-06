package interfaces;

import controllers.CheckoutCart;
import controllers.ItemManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConfigurePricesScreen extends JPanel {

    private JPanel mainPanel;
    private JList pizzaList;
    private JTextField priceField;
    private JLabel label;
    private JButton confirmButton;

    private DefaultListModel listModel;

    private int itemId;
    private double newPrice;

    public ConfigurePricesScreen() {
        add(mainPanel);
        setVisible(true);

        updatePrices();

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
            if (!CheckoutCart.cart.isEmpty()) {
                label.setText("Cannot set price while processing an order");
            } else {
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
                updatePrices();

                label.setText("");
                priceField.setText("");
                priceField.setEnabled(false);
                confirmButton.setEnabled(false);
            }
        });
    }

    public void updatePrices() {
        listModel = new DefaultListModel();

        listModel.addElement("SMALL NO TOPPING PIZZA | $" + ItemManager.getItems().get(1).getPrice());
        listModel.addElement("SMALL TOPPING PIZZA | $" + ItemManager.getItems().get(2).getPrice());
        listModel.addElement("MEDIUM NO TOPPING PIZZA |$ " + ItemManager.getItems().get(11).getPrice());
        listModel.addElement("MEDIUM TOPPING PIZZA | $" + ItemManager.getItems().get(12).getPrice());
        listModel.addElement("LARGE NO TOPPING PIZZA | $" + ItemManager.getItems().get(21).getPrice());
        listModel.addElement("LARGE TOPPING PIZZA | $" + ItemManager.getItems().get(22).getPrice());
        listModel.addElement("SODA | $" + ItemManager.getItems().get(31).getPrice());
        listModel.addElement("TAX PERCENTAGE | " + ItemManager.getItems().get(0).getPrice() + "%");

        pizzaList.setModel(listModel);

        pizzaList.revalidate();
        pizzaList.repaint();
    }
}
