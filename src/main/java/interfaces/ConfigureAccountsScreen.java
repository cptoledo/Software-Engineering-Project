package interfaces;

import controllers.EmployeeManager;
import models.Employee;

import javax.swing.*;

public class ConfigureAccountsScreen extends JPanel {

    private JPanel mainPanel;

    private JList accountsList;

    private JButton addUserButton;
    private JButton deleteUserButton;
    private JButton configureUserButton;

    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField pinField;
    private JLabel pinLabel;
    private JButton confirmButton;

    private DefaultListModel listModel;

    private String selectedUser;
    private String lastName;
    private String firstName;
    private int id;

    public ConfigureAccountsScreen() {
        add(mainPanel);
        setVisible(true);

        updateAccountList();

        accountsList.setModel(listModel);
        accountsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        accountsList.addListSelectionListener(e -> {
            enableAccountOptions();

            String[] dataSplit = ((String) accountsList.getSelectedValue()).split(",");
            selectedUser = dataSplit[2];
        });

        addUserButton.addActionListener(e -> {
            enableFields();
        });

        deleteUserButton.addActionListener(e -> {
            EmployeeManager.removeEmployee(selectedUser);
            updateAccountList();
        });
        configureUserButton.addActionListener(e -> {
            enableFields();
        });
    }

    private void updateAccountList() {
        listModel = new DefaultListModel();

        for (Employee employee : EmployeeManager.getEmployees().values()) {
            listModel.addElement(employee.getLastName() + "," + employee.getFirstName() + ","+ employee.getId());
        }
        //TODO: Refresh list (MainScreen.settingsPanel)
    }

    private void enableAccountOptions() {
        deleteUserButton.setEnabled(true);
        configureUserButton.setEnabled(true);
    }

    private void enableFields() {
        lastNameField.setEnabled(true);
        firstNameField.setEnabled(true);
        pinField.setEnabled(true);
    }
}
