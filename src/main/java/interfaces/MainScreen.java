package interfaces;

import cart.CheckoutCart;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane;

    private JPanel settingsPanel;
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

    public static CheckoutCart cart;

    public MainScreen() {

        setContentPane(mainPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setVisible(true);

        orderSelectionPanel.setLayout(new GridLayout());

        // TODO: PizzaOptionsScreen not appearing on action.
        pizzaButton.addActionListener(e -> {
            orderSelectionPanel.add(new PizzaOptionsScreen());
            orderSelectionPanel.revalidate();
            orderSelectionPanel.repaint();
        });

        logoutButton.addActionListener(e -> {
            new LoginScreen();
            dispose();
        });
    }

    private void refreshCheckoutPanel() {
        checkoutPanel.revalidate();
        checkoutPanel.repaint();
    }
}
