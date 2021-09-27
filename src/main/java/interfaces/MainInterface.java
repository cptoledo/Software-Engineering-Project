package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame implements ActionListener {

    private JButton order;
    private JButton account;
    private JButton logout;

    private JButton pizza;
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
    private JButton coke;
    private JButton sprite;

    private JButton checkout;

    public MainInterface() {
        order = new JButton("ORDER");
        order.addActionListener(this);

        account = new JButton("ACCOUNT");
        account.addActionListener(this);

        logout = new JButton("LOGOUT");
        logout.addActionListener(this);

        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == order) {
            pizza = new JButton("PIZZA");
            pizza.addActionListener(this);

            soda = new JButton("SODA");
            soda.addActionListener(this);
        }
        if (e.getSource() == pizza) {

        } else if (e.getSource() == soda) {

        }
    }

    public void actionPerformed2(ActionEvent e) {

    }
}
