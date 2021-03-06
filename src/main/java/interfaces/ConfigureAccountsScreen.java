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
    private JLabel label;
    private JButton confirmButton;
    private JButton changePinButton;

    private int buttonPressed;

    private DefaultListModel listModel;

    private Employee selectedUser;

    public ConfigureAccountsScreen() {
        add(mainPanel);
        setVisible(true);

        updateAccountList();
        enableFields(false);

        accountsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        accountsList.addListSelectionListener(e -> {
            enableAccountOptions(true);
            enableFields(false);

            String[] dataSplit = ((String) accountsList.getSelectedValue()).split("\\| ");
            selectedUser = EmployeeManager.getEmployees().get(dataSplit[1]);
        });

        addUserButton.addActionListener(e -> {
            buttonPressed = 1;
            enableFields(true);
            accountsList.clearSelection();
        });
        deleteUserButton.addActionListener(e -> {
            enableFields(false);
            if (accountsList.getSelectedIndex() == -1) {
                label.setText("Choose an account");
            } else {
                if (selectedUser.getId().equals(MainScreen.currentEmployee.getId())) {
                    label.setText("Account in use");
                } else {
                    EmployeeManager.removeEmployee(selectedUser.getId());
                    updateAccountList();
                }
            }

        });
        changeNameButton.addActionListener(e -> {
            enableFields(false);
            if (accountsList.getSelectedIndex() == -1) {
                label.setText("Choose an account");
            } else {
                buttonPressed = 2;
                lastNameField.setEditable(true);
                firstNameField.setEditable(true);
                confirmButton.setEnabled(true);
            }

        });
        changePinButton.addActionListener(e -> {
            enableFields(false);
            if (accountsList.getSelectedIndex() == -1) {
                label.setText("Choose an account");
            } else {
                buttonPressed = 3;
                pinField.setEditable(true);
                confirmButton.setEnabled(true);
            }

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

            }
        });

        confirmButton.addActionListener(e -> {
            if (buttonPressed == 1) {
                // Add user
                if (lastNameField.getText().length() == 0) {
                    label.setText("Enter a last name");
                } else if (firstNameField.getText().length() == 0) {
                    label.setText("Enter a first name");
                } else if (lastNameField.getText().length() > 25) {
                    label.setText("Last name must be <= 25 characters");
                } else if (firstNameField.getText().length() > 25) {
                    label.setText("First name must be <= 25 characters");
                } else if (pinField.getText().length() == 0 || pinField.getText().length() != 4) {
                    label.setText("Enter a 4-digit PIN");
                } else if (EmployeeManager.getEmployees().containsKey(pinField.getText())) {
                    label.setText("PIN is not unique");
                } else if (EmployeeManager.getEmployees().size() == 20) {
                    label.setText("Reached 20 max users");
                } else {
                    EmployeeManager.addEmployee(pinField.getText(), firstNameField.getText(), lastNameField.getText());
                    updateAccountList();
                    accountsList.clearSelection();
                }
            } else if (buttonPressed == 2) {
                // Change name
                if (lastNameField.getText().length() == 0) {
                    label.setText("Enter a last name");
                } else if (firstNameField.getText().length() == 0) {
                    label.setText("Enter a first name");
                } else if (lastNameField.getText().length() > 25) {
                    label.setText("Last name must be <= 25 characters");
                } else if (firstNameField.getText().length() > 25) {
                    label.setText("First name must be <= 25 characters");
                } else {
                    EmployeeManager.changeName(selectedUser.getId(), firstNameField.getText(), lastNameField.getText());
                    updateAccountList();
                    accountsList.clearSelection();
                }
            } else if (buttonPressed == 3) {
                // Change PIN
                if (pinField.getText().length() == 0 || pinField.getText().length() != 4) {
                    label.setText("Enter a 4-digit PIN");
                } else if (EmployeeManager.getEmployees().containsKey(pinField.getText())) {
                    label.setText("PIN is not unique");
                } else {
                    EmployeeManager.changeId(selectedUser.getId(), pinField.getText());
                    updateAccountList();
                    accountsList.clearSelection();
                }
            }
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

        clearFields();
        enableFields(false);
    }

    private void enableAccountOptions(boolean flag) {
        deleteUserButton.setEnabled(flag);
        changeNameButton.setEnabled(flag);
        changePinButton.setEnabled(flag);
    }

    private void enableFields(boolean flag) {
        lastNameField.setEditable(flag);
        firstNameField.setEditable(flag);
        pinField.setEditable(flag);
        confirmButton.setEnabled(flag);
        clearFields();
    }

    private void clearFields() {
        lastNameField.setText("");
        firstNameField.setText("");
        pinField.setText("");
        label.setText("");
    }
}
