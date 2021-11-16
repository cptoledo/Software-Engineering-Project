package interfaces;

import controllers.CheckoutCart;
import models.ItemOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OrderOptionsScreen extends JPanel {

    private JPanel mainPanel;

    private JButton smallPepperoni;
    private JButton smallSausage;
    private JButton smallBacon;
    private JButton smallCheese;
    private JButton smallMushroom;
    private JButton smallOnion;
    private JButton smallPeppers;
    private JButton smallPineapple;
    private JButton smallPlain;

    private JButton mediumPepperoni;
    private JButton mediumSausage;
    private JButton mediumBacon;
    private JButton mediumCheese;
    private JButton mediumMushroom;
    private JButton mediumOnion;
    private JButton mediumPeppers;
    private JButton mediumPineapple;
    private JButton mediumPlain;

    private JButton largePepperoni;
    private JButton largeSausage;
    private JButton largeBacon;
    private JButton largeCheese;
    private JButton largeMushroom;
    private JButton largeOnion;
    private JButton largePeppers;
    private JButton largePineapple;
    private JButton largePlain;

    private JButton coke;
    private JButton sprite;

    private JTextField quantityField;
    private JButton addToCartButton;

    private JLabel label;
    private JLabel orderLabel;

    private JTable checkoutList;
    private JButton checkoutButton;
    private JButton clearCartButton;

    private DefaultTableModel tableModel;

    private int itemId = -1;

    private int quantity = 0;
    private int totalPizzas = 0;
    private int totalSodas = 0;

    public OrderOptionsScreen() {
        add(mainPanel);
        setVisible(true);

        updateCart();

        smallPlain.addActionListener(e -> {
            itemId = 1;
            orderLabel.setText("SMALL PLAIN");
        });
        smallPepperoni.addActionListener(e -> {
            itemId = 2;
            orderLabel.setText("SMALL PEPPERONI");
        });
        smallSausage.addActionListener(e -> {
            itemId = 3;
            orderLabel.setText("SMALL SAUSAGE");
        });
        smallBacon.addActionListener(e -> {
            itemId = 4;
            orderLabel.setText("SMALL BACON");
        });
        smallCheese.addActionListener(e -> {
            itemId = 5;
            orderLabel.setText("SMALL EXTRA CHEESE");
        });
        smallMushroom.addActionListener(e -> {
            itemId = 6;
            orderLabel.setText("SMALL MUSHROOM");
        });
        smallOnion.addActionListener(e -> {
            itemId = 7;
            orderLabel.setText("SMALL ONION");
        });
        smallPeppers.addActionListener(e -> {
            itemId = 8;
            orderLabel.setText("SMALL PEPPERS");
        });
        smallPineapple.addActionListener(e -> {
            itemId = 9;
            orderLabel.setText("SMALL PINEAPPLE");
        });

        mediumPlain.addActionListener(e -> {
            itemId = 11;
            orderLabel.setText("MEDIUM PLAIN");
        });
        mediumPepperoni.addActionListener(e -> {
            itemId = 12;
            orderLabel.setText("MEDIUM PEPPERONI");
        });
        mediumSausage.addActionListener(e -> {
            itemId = 13;
            orderLabel.setText("MEDIUM SAUSAGE");
        });
        mediumBacon.addActionListener(e -> {
            itemId = 14;
            orderLabel.setText("MEDIUM BACON");
        });
        mediumCheese.addActionListener(e -> {
            itemId = 15;
            orderLabel.setText("MEDIUM EXTRA CHEESE");
        });
        mediumMushroom.addActionListener(e -> {
            itemId = 16;
            orderLabel.setText("MEDIUM MUSHROOM");
        });
        mediumOnion.addActionListener(e -> {
            itemId = 17;
            orderLabel.setText("MEDIUM ONION");
        });
        mediumPeppers.addActionListener(e -> {
            itemId = 18;
            orderLabel.setText("MEDIUM PEPPERS");
        });
        mediumPineapple.addActionListener(e -> {
            itemId = 19;
            orderLabel.setText("MEDIUM PINEAPPLE");
        });

        largePlain.addActionListener(e -> {
            itemId = 21;
            orderLabel.setText("LARGE PLAIN");
        });
        largePepperoni.addActionListener(e -> {
            itemId = 22;
            orderLabel.setText("LARGE PEPPERONI");
        });
        largeSausage.addActionListener(e -> {
            itemId = 23;
            orderLabel.setText("LARGE SAUSAGE");
        });
        largeBacon.addActionListener(e -> {
            itemId = 24;
            orderLabel.setText("LARGE BACON");
        });
        largeCheese.addActionListener(e -> {
            itemId = 25;
            orderLabel.setText("LARGE EXTRA CHEESE");
        });
        largeMushroom.addActionListener(e -> {
            itemId = 26;
            orderLabel.setText("LARGE MUSHROOM");
        });
        largeOnion.addActionListener(e -> {
            itemId = 27;
            orderLabel.setText("LARGE ONION");
        });
        largePeppers.addActionListener(e -> {
            itemId = 28;
            orderLabel.setText("LARGE PEPPERS");
        });
        largePineapple.addActionListener(e -> {
            itemId = 29;
            orderLabel.setText("LARGE PINEAPPLE");
        });

        coke.addActionListener(e -> {
            itemId = 31;
            orderLabel.setText("COKE");
        });
        sprite.addActionListener(e -> {
            itemId = 32;
            orderLabel.setText("SPRITE");
        });

        quantityField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // To allow only number inputs.
                if (Character.isDigit(e.getKeyChar()) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    quantityField.setEditable(true);
                } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    addToCartButton.doClick();
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
                if (itemId == -1) {
                    quantityField.setText("");
                } else {
                    if (value.length() > 0) {
                        tempQuantity = Integer.parseInt(value);
                    }

                    if (totalPizzas + totalSodas + tempQuantity > 200) {
                        addToCartButton.setEnabled(false);
                        label.setText("Cart exceeds 200 items");
                    } else if (itemId > 0 && itemId < 30 && totalPizzas + tempQuantity > 100) {
                        addToCartButton.setEnabled(false);
                        label.setText("Cart exceeds 100 pizzas");
                    } else if (itemId > 30 && totalSodas + tempQuantity > 100){
                        addToCartButton.setEnabled(false);
                        label.setText("Cart exceeds 100 sodas");
                    } else {
                        addToCartButton.setEnabled(true);
                        label.setText("");
                        quantity = tempQuantity;
                    }
                }
            }
        });

        addToCartButton.addActionListener(e -> {
            if (itemId < 0) {
                label.setText("Must select an order");
            } else if (quantityField.getText().length() == 0) {
                label.setText("Must input quantity");
            } else {
                if (itemId > 0 && itemId < 30) {
                    totalPizzas += quantity;
                } else {
                    totalSodas += quantity;
                }
                CheckoutCart.add(itemId, quantity);
                updateCart();

                // Reset all values
                itemId = -1;
                quantity = 0;

                quantityField.setText("");
                orderLabel.setText("");
                label.setText("");
            }
        });

        clearCartButton.addActionListener(e -> {
            CheckoutCart.clear();
            totalPizzas = 0;
            totalSodas = 0;

            updateCart();
        });
        checkoutButton.addActionListener(e -> {
            CheckoutCart.checkout();
            totalPizzas = 0;
            totalSodas = 0;

            updateCart();
        });
    }

    private void updateCart() {
        tableModel = new DefaultTableModel();

        tableModel.addColumn("ITEMS");
        tableModel.addColumn("QTY");
        tableModel.insertRow(0, new Object[] {"ITEM", "QTY"});
        for (ItemOrder itemOrder : CheckoutCart.getCart()) {
            tableModel.insertRow(1, new Object[] {itemOrder.getDescription(), itemOrder.getNumItems()});
        }
        checkoutList.setModel(tableModel);
        // TODO: Fix the resizing checkout list. Turn it into scrollable list.
        checkoutList.setPreferredScrollableViewportSize(checkoutButton.getPreferredSize());

        checkoutList.revalidate();
        checkoutList.repaint();
    }
}
