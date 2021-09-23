package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JPanel exitPanel;
    private JButton exitButton;
    private JTextField pinField;
    private JLabel label;

    public LoginInterface() {
        pinField = new JTextField();

        label = new JLabel();

        exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(200, 100));
        exitButton.addActionListener(this);

        exitPanel = new JPanel(new BorderLayout());
        exitPanel.add(exitButton, BorderLayout.LINE_END);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(exitPanel, BorderLayout.PAGE_END);

        add(mainPanel);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {

        }
    }
}
