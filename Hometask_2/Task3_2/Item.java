package Hometask_2.Task3_2;

import java.util.UUID;

public class Item {
    private UUID itemsId; // GUID
    private String itemsArticle; // артикул
    private String itemsTitle; // навание
    private int itemsQuantity; // количество
    private double itemsPrice; // цена

    public Item(UUID itemsId, String itemsArticle, String itemsTitle, int itemsQuantity, double itemsPrice){
        this.itemsId = itemsId;
        this.itemsArticle = itemsArticle;
        this.itemsTitle = itemsTitle;
        this.itemsQuantity = itemsQuantity;
        this.itemsPrice = itemsPrice;
    }

    public double getItemsPrice() {
        return itemsPrice;
    }
    public void setItemsPrice(double itemsPrice) {
        this.itemsPrice = itemsPrice;
    }

    public String getItemsTitle() {
        return itemsTitle;
    }
    public void setItemsTitle(String itemsTitle) {
        this.itemsTitle = itemsTitle;
    }

    public int getItemsQuantity() {
        return itemsQuantity;
    }
    public void setItemsQuantity(int itemsQuantity) {
        this.itemsQuantity = itemsQuantity;
    }

    public UUID getItemsId() {
        return itemsId;
    }
    public void setItemsId(UUID itemsId) {
        this.itemsId = itemsId;
    }

    public String getItemsArticle() {
        return itemsArticle;
    }
    public void setItemsArticle(String itemsArticle) {
        this.itemsArticle = itemsArticle;
    }
}
