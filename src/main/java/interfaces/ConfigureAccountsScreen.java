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
    private JLabel pinLabel;
    private JButton confirmButton;
    private JButton changePinButton;

    private int buttonPressed;

    private DefaultListModel listModel;

    private String selectedUser;
    private String lastName;
    private String firstName;
    private int id;

    public ConfigureAccountsScreen() {
        add(mainPanel);
        setVisible(true);

        updateAccountList();

        accountsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        accountsList.addListSelectionListener(e -> {
            enableAccountOptions();

            String[] dataSplit = ((String) accountsList.getSelectedValue()).split("\\| ");
            selectedUser = dataSplit[1];
        });

        addUserButton.addActionListener(e -> {
            buttonPressed = 1;
            enableFields();
        });
        deleteUserButton.addActionListener(e -> {
            EmployeeManager.removeEmployee(selectedUser);
            updateAccountList();
        });
        changeNameButton.addActionListener(e -> {
            buttonPressed = 2;
            lastNameField.setEnabled(true);
            firstNameField.setEnabled(true);
        });
        changePinButton.addActionListener(e -> {
            buttonPressed = 3;
            pinField.setEnabled(true);

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

            } else if (buttonPressed == 2) {
                // Change name

            } else if (buttonPressed == 3) {
                // Change PIN

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
    }

    private void disableFields() {
        lastNameField.setEnabled(false);
        firstNameField.setEnabled(false);
        pinField.setEnabled(false);
    }
}
