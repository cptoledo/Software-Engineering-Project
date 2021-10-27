package interfaces;

import controllers.CheckoutCart;
import models.ItemOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// TODO: TEST CLASS
public class CheckoutList extends JTable {

    private DefaultTableModel tableModel;

    public CheckoutList() {
        setVisible(true);
    }

    public void updateCheckoutList() {
        tableModel = new DefaultTableModel();

        for (ItemOrder itemOrder : CheckoutCart.getCart()) {
            tableModel.setValueAt(itemOrder.getDescription(), getSelectedRow(), 0);
            tableModel.setValueAt(itemOrder.getNumItems(), getSelectedRow(), 1);
        }
        setModel(tableModel);

        revalidate();
        repaint();
    }
}
