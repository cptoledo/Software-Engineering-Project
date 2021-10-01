package interfaces;

import controllers.EmployeeManager;
import models.Employee;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;

public class LoginUI extends JFrame implements ActionListener {

    private JButton exitButton;
    private JLabel confirmationLabel;
    private JLabel promptLabel;
    private JPanel loginPanel;
    private JFormattedTextField pinField;

    HashMap<String, Employee> employeeMap = new EmployeeManager().getEmployees();

    public LoginUI() {
        add(loginPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        exitButton.addActionListener(this);

        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
        pinField.setFormatterFactory(factory);
        pinField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == pinField) {
            if (pinField.getText().length() == 4) {
                if (employeeMap.containsKey(pinField.getText())) {
                    confirmationLabel.setText("VALID");
                } else {
                    confirmationLabel.setText("INVALID");
                }
            }
        }
    }
}
