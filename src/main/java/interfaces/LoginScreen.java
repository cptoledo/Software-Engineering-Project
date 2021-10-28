package interfaces;

import controllers.EmployeeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginScreen extends JFrame {

    private JTextField pinField;
    private JButton exitButton;
    private JLabel promptLabel;
    private JPanel mainPanel;
    private JLabel confirmLabel;

    public LoginScreen() {
        add(mainPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        pinField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // To allow only number inputs.
                if (Character.isDigit(e.getKeyChar()) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    pinField.setEditable(true);
                } else {
                    pinField.setEditable(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String value = pinField.getText();

                // Check if PIN is registered in the system.
                if (pinField.getText().length() >= 4) {
                    if (EmployeeManager.getEmployees().containsKey(value)) {
                        new MainScreen(EmployeeManager.getEmployees().get(value));
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
