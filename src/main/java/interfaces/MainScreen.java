package interfaces;

import models.Employee;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane;

    private JPanel optionsPanel;
    private JButton accountsButton;
    private JButton pricesButton;
    private JButton logoutButton;

    private JPanel orderPanel;

    private JPanel settingsPanel;
    private OrderOptionsScreen pizzaOptionsScreen;

    public static Employee currentEmployee;

    public MainScreen(Employee employee) {
        setContentPane(mainPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setVisible(true);

        currentEmployee = employee;

        settingsPanel.setLayout(new GridBagLayout());
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
        logoutButton.setBackground(Color.RED);
    }

    private void setPanel(JPanel panel, JPanel newPanel) {
        panel.removeAll();
        panel.add(newPanel);
        panel.revalidate();
        panel.repaint();
    }
}
