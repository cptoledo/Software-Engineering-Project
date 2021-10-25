package interfaces;

import controllers.EmployeeManager;
import models.Employee;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConfigureAccountsScreen extends JPanel {

    private JPanel mainPanel;

    private JList accountsList;

    private JButton addUserButton;
    private JButton deleteUserButton;
    private JButton changeNameButton;

    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField pinField;
    private JLabel firstNameLabel;
    private JButton confirmButton;
    private JButton changePinButton;

    private int buttonPressed;

    private DefaultListModel listModel;

    private Employee selectedUser;

    public ConfigureAccountsScreen() {
        add(mainPanel);
        setVisible(true);

        updateAccountList();

        accountsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        accountsList.addListSelectionListener(e -> {
            enableAccountOptions();
            disableFields();

            String[] dataSplit = ((String) accountsList.getSelectedValue()).split("\\| ");
            selectedUser = EmployeeManager.getEmployees().get(dataSplit[1]);
        });

        addUserButton.addActionListener(e -> {
            buttonPressed = 1;
            enableFields();
        });
        deleteUserButton.addActionListener(e -> {
            disableFields();
            EmployeeManager.removeEmployee(selectedUser.getId());
            updateAccountList();
        });
        changeNameButton.addActionListener(e -> {
            disableFields();
            buttonPressed = 2;
            lastNameField.setEnabled(true);
            firstNameField.setEnabled(true);
            confirmButton.setEnabled(true);
        });
        changePinButton.addActionListener(e -> {
            disableFields();
            buttonPressed = 3;
            pinField.setEnabled(true);
            confirmButton.setEnabled(true);
        });

        lastNameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        firstNameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
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
                if (pinField.getText().length() == 4) {
                    pinField.setEditable(false);
                }
            }
        });

        confirmButton.addActionListener(e -> {
            if (buttonPressed == 1) {
                // Add user
                if (lastNameField.getText().length() == 0) {
                    firstNameLabel.setText("Enter a last name");
                } else if (firstNameField.getText().length() == 0) {
                    firstNameLabel.setText("Enter a first name");
                } else if (pinField.getText().length() == 0) {
                    firstNameLabel.setText("Enter a PIN");
                } else {
                    EmployeeManager.addEmployee(pinField.getText(), firstNameField.getText(), lastNameField.getText());
                }
            } else if (buttonPressed == 2) {
                // Change name
                if (lastNameField.getText().length() == 0) {
                    firstNameLabel.setText("Enter a last name");
                } else if (firstNameField.getText().length() == 0) {
                    firstNameLabel.setText("Enter a first name");
                } else {
                    EmployeeManager.changeName(selectedUser.getId(), firstNameField.getText(), lastNameField.getText());
                }
            } else if (buttonPressed == 3) {
                // Change PIN
                if (pinField.getText().length() == 0 || pinField.getText().length() != 4) {
                    firstNameLabel.setText("Enter a 4-digit PIN");
                } else {
                    EmployeeManager.changeId(selectedUser.getId(), pinField.getText());
                }
            }
            updateAccountList();
        });
    }

    private void updateAccountList() {
        listModel = new DefaultListModel();

        for (Employee employee : EmployeeManager.getEmployees().values()) {
            listModel.addElement(employee.getLastName() + ", " + employee.getFirstName() + " | "+ employee.getId());
        }
        accountsList.setModel(listModel);

        accountsList.revalidate();
        accountsList.repaint();
    }

    private void enableAccountOptions() {
        deleteUserButton.setEnabled(true);
        changeNameButton.setEnabled(true);
        changePinButton.setEnabled(true);
    }

    private void enableFields() {
        lastNameField.setEnabled(true);
        firstNameField.setEnabled(true);
        pinField.setEnabled(true);
        confirmButton.setEnabled(true);
    }

    private void disableFields() {
        lastNameField.setEnabled(false);
        firstNameField.setEnabled(false);
        pinField.setEnabled(false);
        confirmButton.setEnabled(false);
        clearFields();
    }

    private void clearFields() {
        lastNameField.setText("");
        firstNameField.setText("");
        pinField.setText("");
        firstNameLabel.setText("");
    }
}
