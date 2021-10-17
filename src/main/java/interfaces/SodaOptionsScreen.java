package interfaces;

import controllers.ItemManager;
import models.Item;
import org.iq80.snappy.Main;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class SodaOptionsScreen extends JPanel {

    private JPanel mainPanel;

    private JButton cokeButton;
    private JButton spriteButton;

    private JTextField quantityField;
    private JButton addToCartButton;
    private JLabel label;
    private JLabel sodaLabel;

    private int itemId = -1;

    private int quantity;

    public SodaOptionsScreen() {
        add(mainPanel);
        setVisible(true);

        cokeButton.addActionListener(e -> {
            itemId = 31;
            sodaLabel.setText("COKE");
        });
        spriteButton.addActionListener(e -> {
            itemId = 32;
            sodaLabel.setText("SPRITE");
        });

        quantityField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // To allow only number inputs.
                if (Character.isDigit(e.getKeyChar()) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    quantityField.setEditable(true);
                } else {
                    quantityField.setEditable(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String value = quantityField.getText();
                int tempQuantity = 0;
                if (value.length() > 0) {
                    tempQuantity = Integer.parseInt(value);
                }

                if (MainScreen.totalPizzas + MainScreen.totalPizzas + tempQuantity > 200) {
                    addToCartButton.setEnabled(false);
                    label.setText("Cart exceeds 200 items");
                } else if (MainScreen.totalSodas + tempQuantity > 100) {
                    addToCartButton.setEnabled(false);
                    label.setText("Cart exceeds 100 sodas");
                } else if (tempQuantity > 100) {
                    addToCartButton.setEnabled(false);
                    label.setText("Must be <= 100");
                    quantity = Integer.parseInt(value);
                } else {
                    addToCartButton.setEnabled(true);
                    label.setText("");
                    quantity = tempQuantity;
                }
            }
        });

        addToCartButton.addActionListener(e -> {
            //TODO: If soda is not selected.
            MainScreen.totalSodas += quantity;
            MainScreen.cart.add(itemId, quantity);
        });
    }
}
