package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton exitButton;
    private JTextField pinField;
    private JLabel label;

    public LoginInterface() {
        panel = new JPanel();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        exitButton = new JButton("EXIT");
        exitButton.setSize(40, 20);
        panel.add(exitButton);
        exitButton.addActionListener(this);
        add(exitButton);

        pinField = new JTextField();

        label = new JLabel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {

        }
    }
}
