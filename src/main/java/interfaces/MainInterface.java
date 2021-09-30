package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JPanel optionsPanel;

    private JButton order;
    private JPanel orderPanel;
    private JButton account;
    private JPanel accountPanel;
    private JButton logout;

    private JButton pizza;
    private JPanel pizzaPanel;
    private JButton smallPizza;
    private JButton mediumPizza;
    private JButton largePizza;
    private JButton bacon;
    private JButton pepperoni;
    private JButton sausage;
    private JButton peppers;
    private JButton extraCheese;
    private JButton mushrooms;
    private JButton pineapple;
    private JButton onions;

    private JButton soda;
    private JPanel sodaPanel;
    private JButton coke;
    private JButton sprite;

    private JButton checkout;
    private JPanel checkoutPanel;

    public MainInterface() {
        optionsPanel = new JPanel();
        optionsPanel.setPreferredSize(new Dimension(900, 300));
        optionsPanel.setLayout(new GridLayout(1, 3, 50, 50));

        order = new JButton("ORDER");
        order.setBackground(Color.GREEN);
        order.addActionListener(this);
        optionsPanel.add(order);

        account = new JButton("ACCOUNT");
        account.setBackground(Color.BLUE);
        account.addActionListener(this);
        optionsPanel.add(account);

        logout = new JButton("LOGOUT");
        logout.setBackground(Color.RED);
        logout.addActionListener(this);
        optionsPanel.add(logout);

        mainPanel = new JPanel();
        mainPanel.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        mainPanel.add(optionsPanel);

        setContentPane(mainPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == order) {
            JPanel orderPanel = new JPanel();
            orderPanel.setBounds(240, 240, 200, 500);

            pizza = new JButton("PIZZA");
            pizza.addActionListener(this);
            orderPanel.add(pizza);

            soda = new JButton("SODA");
            soda.addActionListener(this);
            orderPanel.add(soda);

            mainPanel.add(orderPanel);
        }
        if (e.getSource() == pizza) {

        } else if (e.getSource() == soda) {

        }
    }

    public void actionPerformed2(ActionEvent e) {

    }
}
