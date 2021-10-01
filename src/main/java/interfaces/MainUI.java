package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame implements ActionListener {

    private JButton orderButton;
    private JButton accountButton;
    private JButton logoutButton;
    private JPanel optionsPanel;

    public MainUI() {
        add(optionsPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        orderButton.addActionListener(this);

        accountButton.addActionListener(this);

        logoutButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderButton) {
            new OrderUI();
        }
        if (e.getSource() == accountButton) {

        }
        if (e.getSource() == logoutButton) {
            new LoginUI();
        }
        dispose();
    }
}
