package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JPanel promptPanel;
    private JPanel pinPanel;
    private JPanel invalidPanel;
    private JPanel exitPanel;
    private JButton exitButton;
    private JTextField pinField;
    private JLabel promptLabel;
    private JLabel invalidLabel;

    public LoginInterface() {
        pinField = new JTextField();
        pinField.setHorizontalAlignment(JLabel.CENTER);

        pinPanel = new JPanel();
        pinPanel.add(pinField);

        promptLabel = new JLabel("Enter PIN:");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);

        promptPanel = new JPanel();
        promptPanel.add(pinPanel);

        invalidLabel = new JLabel();

        exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(100, 50));
        exitButton.addActionListener(this);

        exitPanel = new JPanel(new BorderLayout());
        exitPanel.add(exitButton, BorderLayout.LINE_END);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(promptLabel, BorderLayout.CENTER);
        promptPanel.add(pinPanel, BorderLayout.CENTER);
        mainPanel.add(exitPanel, BorderLayout.PAGE_END);

        setContentPane(mainPanel);

        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
    }

    public void setInvalidLabel(String text) {
        invalidLabel.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
