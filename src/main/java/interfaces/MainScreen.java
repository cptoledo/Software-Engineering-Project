package interfaces;

import cart.CheckoutCart;
import models.Employee;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane;

    private JPanel optionsPanel;
    private JButton accountsButton;
    private JButton shopButton;
    private JButton logoutButton;

    private JPanel orderPanel;
    private JButton pizzaButton;
    private JButton sodaButton;
    private JPanel orderSelectionPanel;

    private JPanel checkoutPanel;
    private JTable checkoutList;
    private JButton checkoutButton;
    private JButton clearCartButton;

    private JPanel settingsPanel;

    public static CheckoutCart cart;

    public static int totalSodas;
    public static int totalPizzas;

    public static Employee currentEmployee;

    //TODO: Properly add items to cart.
    //TODO: Update checkout list whenever an item is added to the cart.
    public MainScreen(Employee employee) {
        setContentPane(mainPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setVisible(true);

        currentEmployee = employee;

        cart = new CheckoutCart();

        orderSelectionPanel.setLayout(new GridLayout());

        pizzaButton.addActionListener(e -> {
            clearPanel(orderSelectionPanel);
            orderSelectionPanel.add(new PizzaOptionsScreen());
            refreshPanel(orderSelectionPanel);
        });

        sodaButton.addActionListener(e -> {
            clearPanel(orderSelectionPanel);
            orderSelectionPanel.add(new SodaOptionsScreen());
            refreshPanel(orderSelectionPanel);
        });

        clearCartButton.addActionListener(e -> {
            cart.clear();
            totalPizzas = 0;
            totalSodas = 0;
        });

        checkoutButton.addActionListener(e -> {
            cart.checkOut();
            totalPizzas = 0;
            totalSodas = 0;

            new ReceiptScreen(cart);
        });

        logoutButton.addActionListener(e -> {
            new LoginScreen();
            dispose();
        });
    }

    private void clearPanel(JPanel panel) {
        panel.removeAll();
    }

    public static void refreshPanel(JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }

    public void refreshCart() {
        checkoutPanel.revalidate();
        checkoutPanel.repaint();
    }
}
