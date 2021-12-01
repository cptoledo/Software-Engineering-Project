package controllers;

import models.Item;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ItemManager {

    public static HashMap<Integer, Item> getItems() {
        File file = new File("src/main/resources/itemdata.txt");
        HashMap<Integer, Item> itemMap = new HashMap<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                Item item = new Item();
                item.setId(Integer.parseInt(dataSplit[0]));
                item.setDescription(dataSplit[1]);
                item.setPrice(Double.parseDouble(dataSplit[2]));

                itemMap.put(item.getId(), item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemMap;
    }

    /**
     * Method to set a new price of an item or new sales tax percentage.
     * @param id    An item ID.
     * @param price A price.
     */
    public static void setPrice(int id, double price) {
        File file = new File("src/main/resources/itemdata.txt");
        HashMap<Integer, Item> itemMap = getItems();

        try {
            // Clear old data in text file.
            PrintWriter pw = new PrintWriter(file);
            pw.write("");
            pw.close();

            // Writer new data in text file.
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            for (Item item : itemMap.values()) {
                String data = item.getId() + "," + item.getDescription() + "," + item.getPrice();
                String itemId = item.getId() + "";
                String newPrice = new DecimalFormat("0.00").format(price);
                if (id != item.getId()) {
                    writer.append(data).append("\n");
                } else {
                    writer.append(itemId).append(",").append(item.getDescription()).append(",").append(newPrice).append("\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
