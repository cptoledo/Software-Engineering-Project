package interfaces;

import javax.swing.*;

public class AccountsOptionsScreen extends JPanel {

    private JPanel mainPanel;

    private JButton addUserButton;
    private JButton deleteUserButton;
    private JButton changePINButton;
    private JButton changeNameButton;
    private JButton backButton;

    private JList accountsList;

    public AccountsOptionsScreen() {
        add(mainPanel);
        setVisible(true);

    }
}
