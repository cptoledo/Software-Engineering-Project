package cart;

import controllers.ItemManager;
import models.Item;
import models.ItemOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckoutCart {

    private final HashMap<Integer, Item> itemMap = new ItemManager().getItems();
    private ArrayList<ItemOrder> cart = new ArrayList<>(200);

    public void add(int id, int quantity) {
        if (itemMap.containsKey(id)) {
            String description = itemMap.get(id).getDescription();
            double price = itemMap.get(id).getPrice();
            ItemOrder itemOrder = new ItemOrder(description, quantity, price);
            cart.add(itemOrder);
        }
    }

    public void clear() {
        cart.clear();
    }

    public ArrayList<ItemOrder> getCart() {
        return cart;
    }

    public void checkOut() {
        //TODO
        cart.clear();
    }
}
