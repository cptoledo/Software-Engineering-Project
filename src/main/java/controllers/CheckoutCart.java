package controllers;

import interfaces.ReceiptScreen;
import models.ItemOrder;

import java.util.ArrayList;

public class CheckoutCart {

    public static ArrayList<ItemOrder> cart = new ArrayList<>(200);

    public static ArrayList<ItemOrder> getCart() {
        return cart;
    }

    public static void add(int id, int quantity) {
        String description = ItemManager.getItems().get(id).getDescription();
        double price = ItemManager.getItems().get(id).getPrice() * quantity;
        ItemOrder itemOrder = new ItemOrder(description, quantity, price);

        cart.add(itemOrder);
    }

    public static void clear() {
        cart.clear();
    }

    public static void checkOut() {
        if (!cart.isEmpty()) {
            new ReceiptScreen(cart);
            cart.clear();
        }
    }
}
