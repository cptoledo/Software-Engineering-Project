package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderUI extends JFrame implements ActionListener {

    private JButton pizza;
    private JButton small;
    private JButton medium;
    private JButton large;
    private JButton bacon;
    private JButton pepperoni;
    private JButton sausage;
    private JButton peppers;
    private JButton extraCheese;
    private JButton onion;
    private JButton mushroom;
    private JButton pineapple;

    private JButton soda;
    private JButton coke;
    private JButton sprite;

    private JPanel orderPanel;
    private JButton back;

    public OrderUI() {
        add(orderPanel);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        pizza.addActionListener(this);

        soda.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pizza) {
        }
    }
}
