package interfaces;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

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
    private final Collection<JButton> toppingButtons = new ArrayList<JButton>() {{
        add(pepperoniButton);
        add(sausageButton);
        add(baconButton);
        add(extraCheeseButton);
        add(mushroomButton);
        add(onionButton);
        add(peppersButton);
        add(noToppingButton);
    }};

    private JTextField quantityField;
    private JButton addToCartButton;

    private JLabel label;

    private int pizzaSize;      // 0: small, 1: medium, 2: large
    private int topping;        // 0: no topping, 1: pepperoni, 2: sausage, 3: bacon, 4: extra cheese, 5:mushroom, 6: onion, 7: peppers, 8: pineapple
    private int itemId = 0;

    // TODO: Work on checkout mechanic.
    public PizzaOptionsScreen() {

        add(mainPanel);
        setVisible(true);

        smallButton.addActionListener(e -> {
            pizzaSize = 0;
            setPressed(smallButton);
        });
        mediumButton.addActionListener(e -> {
            pizzaSize = 1;
            setPressed(mediumButton);
        });
        largeButton.addActionListener(e -> {
            pizzaSize = 2;
            setPressed(largeButton);
        });
        noToppingButton.addActionListener(e -> {
            topping = 0;
            setPressed(noToppingButton);
        });
        pepperoniButton.addActionListener(e -> {
            topping = 1;
            setPressed(pepperoniButton);
        });
        sausageButton.addActionListener(e -> {
            topping = 2;
            setPressed(sausageButton);
        });
        baconButton.addActionListener(e -> {
            topping = 3;
            setPressed(baconButton);
        });
        extraCheeseButton.addActionListener(e -> {
            topping = 4;
            setPressed(extraCheeseButton);
        });
        mushroomButton.addActionListener(e -> {
            topping = 5;
            setPressed(mushroomButton);
        });
        onionButton.addActionListener(e -> {
            topping = 6;
            setPressed(onionButton);
        });
        peppersButton.addActionListener(e -> {
            topping = 7;
            setPressed(peppersButton);
        });
        pineappleButton.addActionListener(e -> {
            topping = 8;
            setPressed(pineappleButton);
        });

        quantityField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String value = quantityField.getText();

                quantityField.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9');

                if (Integer.parseInt(value) > 100) {
                    addToCartButton.setEnabled(false);
                    label.setText("Must be <= 100");
                } else {
                    addToCartButton.setEnabled(true);
                    label.setText("");
                }
            }
        });

        addToCartButton.addActionListener(e -> {
            itemId = (pizzaSize * 10) + (topping + 1);
            MainScreen.cart.add(itemId);
        });
    }

    // TODO: Display button is 'pressed' mode when selected.
    private void setPressed(JButton button) {
            for (JButton dButton : toppingButtons) {
                dButton.setOpaque(false);
                //button.getModel().setPressed(true);
            }
            pineappleButton.setOpaque(false);
            button.setOpaque(true);
    }
}
