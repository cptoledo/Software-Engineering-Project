package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderInterface extends JPanel implements ActionListener {

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

    public OrderInterface() {
        pizza = new JButton("PIZZA");
        pizza.addActionListener(this);
        add(pizza);

        soda = new JButton("SODA");
        soda.addActionListener(this);
        add(soda);

        //setLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pizza) {
            pizzaPanel = new JPanel();

            smallPizza = new JButton("SMALL");
            smallPizza.setBackground(Color.YELLOW);
            pizzaPanel.add(smallPizza);

            mediumPizza = new JButton("MEDIUM");
            mediumPizza.setBackground(Color.YELLOW);
            pizzaPanel.add(mediumPizza);

            largePizza = new JButton("LARGE");
            largePizza.setBackground(Color.YELLOW);
            pizzaPanel.add(largePizza);

            bacon = new JButton("BACON");
            bacon.setBackground(Color.YELLOW);
            pizzaPanel.add(bacon);

            pepperoni = new JButton("PEPPERONI");
            pepperoni.setBackground(Color.YELLOW);
            pizzaPanel.add(pepperoni);

            sausage = new JButton("SAUSAGE");
            sausage.setBackground(Color.YELLOW);
            pizzaPanel.add(sausage);

            peppers = new JButton("PEPPERS");
            peppers.setBackground(Color.YELLOW);
            pizzaPanel.add(peppers);

            extraCheese = new JButton("EXTRA CHEESE");
            extraCheese.setBackground(Color.YELLOW);
            pizzaPanel.add(extraCheese);

            mushrooms = new JButton("MUSHROOMS");
            mushrooms.setBackground(Color.YELLOW);
            pizzaPanel.add(mushrooms);

            pineapple = new JButton("PINEAPPLE");
            pineapple.setBackground(Color.YELLOW);
            pizzaPanel.add(pineapple);

            onions = new JButton("ONIONS");
            onions.setBackground(Color.YELLOW);
            pizzaPanel.add(onions);

            add(pizzaPanel);
        }
    }
}
