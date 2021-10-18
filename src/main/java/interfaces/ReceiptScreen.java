package interfaces;

import cart.CheckoutCart;
import util.TimeUtils;

import javax.swing.*;

public class ReceiptScreen extends JFrame {

    private JPanel mainPanel;

    private JLabel shopInfoLabel;

    private JLabel cashierLabel;
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JLabel customerLabel;

    private JLabel orderLabel;
    private JLabel pricesLabel;

    private JLabel totalsLabel;

    // TODO: Get cart items into receipt.
    // TODO: Get cart prices into receipt.
    public ReceiptScreen(CheckoutCart cart) {
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);

        dateLabel.setText(TimeUtils.getTimeString("MM/d/yyyy"));
        timeLabel.setText(TimeUtils.getTimeString("h:mm:ss a"));

        orderLabel.setText("");
        pricesLabel.setText("");

        totalsLabel.setText("");
    }
}
