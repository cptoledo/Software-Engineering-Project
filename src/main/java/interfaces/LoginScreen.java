package interfaces;

import controllers.EmployeeManager;
import models.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class LoginScreen extends JFrame {

    private JTextField pinField;
    private JButton exitButton;
    private JLabel promptLabel;
    private JPanel mainPanel;
    private JLabel confirmLabel;

    HashMap<String, Employee> employeeMap = new EmployeeManager().getEmployees();

    public LoginScreen() {
        add(mainPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        pinField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String value = pinField.getText();

                // To allow only number inputs.
                pinField.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9');

                // Check if PIN is registered in the system.
                if (pinField.getText().length() == 4) {
                    if (employeeMap.containsKey(value)) {
                        new MainScreen();
                        dispose();
                    } else {
                        pinField.setText("");
                        confirmLabel.setText("Invalid PIN");
                    }
                }
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
    }
}
