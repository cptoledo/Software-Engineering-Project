package cart;

import controllers.ItemManager;
import models.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckoutCart {

    private final HashMap<Integer, Item> itemMap = new ItemManager().getItems();
    protected ArrayList<Item> cart = new ArrayList<>();

    public void add(int id) {
        //TODO
        if (itemMap.containsKey(id)) {
            cart.add(itemMap.get(id));
        }
    }

    public void clear() {
        cart.clear();
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void checkOut() {
        //TODO
    }
}
