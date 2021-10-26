package interfaces;

import controllers.CheckoutCart;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PizzaOptionsScreen extends JPanel {

    private JPanel mainPanel;

    private JButton smallButton;
    private JButton mediumButton;
    private JButton largeButton;

    private JButton pepperoniButton;
    private JButton sausageButton;
    private JButton baconButton;
    private JButton extraCheeseButton;
    private JButton mushroomButton;
    private JButton onionButton;
    private JButton peppersButton;
    private JButton pineappleButton;
    private JButton noToppingButton;

    private JTextField quantityField;
    private JButton addToCartButton;

    private JLabel label;
    private JLabel sizeLabel;
    private JLabel toppingLabel;

    private int pizzaSize = -1;     // 0: small, 1: medium, 2: large
    private int topping = -1;       // 0: no topping, 1: pepperoni, 2: sausage, 3: bacon, 4: extra cheese, 5:mushroom, 6: onion, 7: peppers, 8: pineapple
    private int itemId = -1;

    private int quantity = 0;

    public PizzaOptionsScreen() {
        add(mainPanel);
        setVisible(true);

        smallButton.addActionListener(e -> {
            pizzaSize = 0;
            sizeLabel.setText("SMALL");
        });
        mediumButton.addActionListener(e -> {
            pizzaSize = 1;
            sizeLabel.setText("MEDIUM");
        });
        largeButton.addActionListener(e -> {
            pizzaSize = 2;
            sizeLabel.setText("LARGE");
        });
        noToppingButton.addActionListener(e -> {
            topping = 0;
            toppingLabel.setText("NONE");
        });
        pepperoniButton.addActionListener(e -> {
            topping = 1;
            toppingLabel.setText("PEPPERONI");
        });
        sausageButton.addActionListener(e -> {
            topping = 2;
            toppingLabel.setText("SAUSAGE");
        });
        baconButton.addActionListener(e -> {
            topping = 3;
            toppingLabel.setText("BACON");
        });
        extraCheeseButton.addActionListener(e -> {
            topping = 4;
            toppingLabel.setText("EXTRA CHEESE");
        });
        mushroomButton.addActionListener(e -> {
            topping = 5;
            toppingLabel.setText("MUSHROOM");
        });
        onionButton.addActionListener(e -> {
            topping = 6;
            toppingLabel.setText("ONION");
        });
        peppersButton.addActionListener(e -> {
            topping = 7;
            toppingLabel.setText("PEPPERS");
        });
        pineappleButton.addActionListener(e -> {
            topping = 8;
            toppingLabel.setText("PINEAPPLE");
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

                if (MainScreen.totalPizzas + MainScreen.totalSodas + tempQuantity > 200) {
                    addToCartButton.setEnabled(false);
                    label.setText("Cart exceeds 200 items");
                } else if (MainScreen.totalPizzas + tempQuantity > 100) {
                    addToCartButton.setEnabled(false);
                    label.setText("Cart exceeds 100 pizzas");
                } else if (tempQuantity > 100) {
                    addToCartButton.setEnabled(false);
                    label.setText("Must be <= 100");
                } else {
                    addToCartButton.setEnabled(true);
                    label.setText("");
                    quantity = tempQuantity;
                }
            }
        });

        addToCartButton.addActionListener(e -> {
            if (pizzaSize < 0) {
                label.setText("Must select size");
            } else if (topping < 0) {
                label.setText("Must select topping");
            } else if (quantityField.getText().length() == 0) {
                label.setText("Must input quantity");
            } else {
                itemId = (pizzaSize * 10) + (topping + 1);
                MainScreen.totalPizzas += quantity;
                CheckoutCart.add(itemId, quantity);

                // Reset all values
                pizzaSize = -1;
                topping = -1;
                itemId = -1;
                quantity = 0;

                quantityField.setText("");
                sizeLabel.setText("");
                toppingLabel.setText("");
                label.setText("");
            }
        });
    }
}
