package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton exitButton;
    private JTextField pinField;
    private JTextPane textPane;

    public LoginInterface() {
        panel = new JPanel();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        exitButton = new JButton("EXIT");
        exitButton.setSize(40, 20);
        panel.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        pinField = new JTextField();

        textPane = new JTextPane();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
