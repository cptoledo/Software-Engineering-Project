package controllers;

import models.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ItemManager {

    public HashMap<String, Item> getItems() {
        HashMap<String, Item> itemMap = new HashMap<>();

        File file = new File("itemdata.txt");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                Item item = new Item();
                item.setId(dataSplit[0]);
                item.setDescription(dataSplit[1]);
                item.setPrice(Double.parseDouble(dataSplit[2]));

                itemMap.put(item.getId(), item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemMap;
    }
}
