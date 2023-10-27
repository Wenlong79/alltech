package com.question2;

public class Item {
    private String itemId;
    private String itemName;

    /**
     *
     * @param itemId
     * @param itemName
     */
    public Item(String itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public Item() {

    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Item -> {" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
