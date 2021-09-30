package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JPanel optionsPanel;

    private JButton order;
    private JButton account;
    private JButton logout;

    private JButton checkout;
    private JPanel checkoutPanel;

    public MainInterface() {
        optionsPanel = new JPanel();
        optionsPanel.setPreferredSize(new Dimension(1050, 300));
        optionsPanel.setLayout(new GridLayout(1, 3, 50, 50));

        order = new JButton("ORDER");
        order.setBackground(Color.GREEN);
        order.setForeground(Color.WHITE);
        order.setFont(new Font("", Font.PLAIN, 20));
        order.addActionListener(this);
        optionsPanel.add(order);

        account = new JButton("ACCOUNT");
        account.setBackground(Color.BLUE);
        account.setForeground(Color.WHITE);
        account.setFont(new Font("", Font.PLAIN, 20));
        account.addActionListener(this);
        optionsPanel.add(account);

        logout = new JButton("LOGOUT");
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("", Font.PLAIN, 20));
        logout.addActionListener(this);
        optionsPanel.add(logout);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        mainPanel.add(optionsPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == order) {
            mainPanel.remove(optionsPanel);
            mainPanel.add(new OrderInterface());
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }
}
