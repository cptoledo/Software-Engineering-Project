package controllers;

import models.Item;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ItemManager {

    public static HashMap<Integer, Item> getItems() {
        HashMap<Integer, Item> itemMap = new HashMap<>();

        File file = new File("src/main/resources/itemdata.txt");

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
        String tempFile = "src/main/resources/tempitemdata.txt";
        File oldFile = new File("src/main/resources/itemdata.txt");
        File newFile = new File(tempFile);

        try {
            Scanner scanner = new Scanner(oldFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            boolean match = false;
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] dataSplit = data.split(",");

                if (!(id == Integer.parseInt(dataSplit[0]))) {
                    writer.append(data).append("\n");
                } else {
                    writer.append(dataSplit[0]).append(",").append(dataSplit[1]).append(",").append(String.valueOf(price)).append("\n");
                    match = true;
                }
                scanner.close();
                writer.close();

                if (match) {
                    oldFile.delete();
                    File dump = new File("src/main/resources/itemdata.txt");
                    newFile.renameTo(dump);
                } else {
                    newFile.delete();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
