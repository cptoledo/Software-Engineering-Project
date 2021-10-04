package interfaces;

import controllers.EmployeeManager;
import models.Employee;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

        promptLabel.setFont(new Font("", Font.PLAIN, 20));

        exitButton.addActionListener(this);

        //NumberFormat format = NumberFormat.getIntegerInstance();
        //format.setGroupingUsed(false);
        //NumberFormatter formatter = new NumberFormatter(format);
        //formatter.setValueClass(Integer.class);
        //formatter.setAllowsInvalid(false);
        //formatter.setMinimum(0);
        //formatter.setMaximum(Integer.MAX_VALUE);
        //DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
        //pinField.setFormatterFactory(factory);

        // TODO: FIX CLEARING FIELD ON INVALID ENTRY OR CORRUPT INPUT ON FIRST CORRECT ENTRY
        pinField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    pinField.setEditable(true);
                } else {
                    pinField.setEditable(false);
                }
            }
        });

        boolean flag = true;
        while (flag) {
            if (pinField.getText().length() == 4) {
                if (employeeMap.containsKey(pinField.getText())) {
                    new MainUI();
                    dispose();
                    flag = false;
                } else {
                    pinField.setText(null);
                    confirmationLabel.setText("INVALID PIN");
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
