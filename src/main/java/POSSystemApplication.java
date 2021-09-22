import controllers.ItemManager;
import models.Item;

import java.util.Map;

public class POSSystemApplication {

    public static void main(String[] args) {
        ItemManager itemManager = new ItemManager();
        Map<String, Item> itemMap = itemManager.getItems();

        System.out.print("Yes");
    }
}
