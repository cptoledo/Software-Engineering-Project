package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class POSInterface extends JFrame implements ActionListener {

    private JButton selection;
    private JButton;

    public POSInterface() {
        selection = new JButton();
        selection.addActionListener(this);

        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selection) {
            JButton topping1 = new JButton();
            JButton topping2 = new JButton();
            JButton topping3 = new JButton();
            JButton topping4 = new JButton();

            topping1.addActionListener(this::actionPerformed);
            topping2.addActionListener(this);
            topping3.addActionListener(this);
            topping4.addActionListener(this);
        } else if (e.getSource() == ) {

        }
    }

    public void actionPerformed2(ActionEvent e) {

    }
}
