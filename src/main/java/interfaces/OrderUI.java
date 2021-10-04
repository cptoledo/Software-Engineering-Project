package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderUI extends JPanel implements ActionListener {

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
        setVisible(true);

        small.addActionListener(this);

        medium.addActionListener(this);

        large.addActionListener(this);

        soda.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == small) {
        }
    }
}
