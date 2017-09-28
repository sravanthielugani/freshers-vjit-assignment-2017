package com.restaurant.management.system.model;

public class Item {

    private String itemName;
    private int itemCost;

    public Item(String itemName, int itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }


    public int getItemCost() {
        return itemCost;
    }

    public String getItemName() {
        return itemName;
    }
}
