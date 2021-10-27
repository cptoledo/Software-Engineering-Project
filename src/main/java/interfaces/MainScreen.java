package interfaces;

import controllers.CheckoutCart;
import models.Employee;
import models.ItemOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainScreen extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane;

    private JPanel optionsPanel;
    private JButton accountsButton;
    private JButton pricesButton;
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

    private DefaultTableModel tableModel;

    public static int totalSodas;
    public static int totalPizzas;

    public static Employee currentEmployee;

    //TODO: Update checkout list whenever an item is added to the cart.
    public MainScreen(Employee employee) {
        setContentPane(mainPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setVisible(true);

        currentEmployee = employee;

        orderSelectionPanel.setLayout(new GridLayout());
        settingsPanel.setLayout(new GridLayout());

        // Order listeners
        pizzaButton.addActionListener(e -> {
            setPanel(orderSelectionPanel, new PizzaOptionsScreen());
        });
        sodaButton.addActionListener(e -> {
            setPanel(orderSelectionPanel, new SodaOptionsScreen());
        });

        clearCartButton.addActionListener(e -> {
            CheckoutCart.clear();
            totalPizzas = 0;
            totalSodas = 0;
        });
        checkoutButton.addActionListener(e -> {
            CheckoutCart.checkOut();
            totalPizzas = 0;
            totalSodas = 0;
        });

        // Setting listeners
        accountsButton.addActionListener(e -> {
            setPanel(settingsPanel, new ConfigureAccountsScreen());
        });
        pricesButton.addActionListener(e -> {
            setPanel(settingsPanel, new ConfigurePricesScreen());
        });
        logoutButton.addActionListener(e -> {
            new LoginScreen();
            dispose();
        });
    }

    private void setPanel(JPanel panel, JPanel newPanel) {
        panel.removeAll();
        panel.add(newPanel);
        refreshPanel(panel);
    }

    private void refreshPanel(JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }

    private void updateCart() {
        // TODO: IF NUM ITEMS IN CART CHANGES UPDATE LIST

        tableModel = new DefaultTableModel();

        for (ItemOrder itemOrder : CheckoutCart.getCart()) {
            tableModel.setValueAt(itemOrder.getDescription(), checkoutList.getSelectedRow(), 0);
            tableModel.setValueAt(itemOrder.getNumItems(), checkoutList.getSelectedRow(), 1);
        }
        checkoutList.setModel(tableModel);

        checkoutList.revalidate();
        checkoutList.repaint();
    }
}
