package Hometask_2.Task3_2;

import java.util.UUID;

public class Shipment {
    //private String documentType; // тип отгрузки: sale - продажа, moving - перемещение
    private String storage; // название склада отгрузки
    private String storageOwner; // владелец склада отгрузки
    private Item[] items; // товары

    public Shipment(String storage, String storageOwner, Item[] items){
        this.storage = storage;
        this.storageOwner = storageOwner;
        this.items = items;
    }

    public String getStorage() {
        return storage;
    }
    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Item[] getItems() {
        return items;
    }
    public void setItems(Item[] items) {
        this.items = items;
    }

    public String getStorageOwner() {
        return storageOwner;
    }
    public void setStorageOwner(String storageOwner) {
        this.storageOwner = storageOwner;
    }

    /**
     * Стоимость товара с переданным id.
     */
    public double itemAmount(UUID id) {
        for (Item item : items) {
            if (item.getItemsId() == id) {
                return Math.round(item.getItemsQuantity() * item.getItemsPrice() * 100) / 100.0;
            }
        }
        return 0;
    }
    /**
     * Суммарная стоимость товаров, попадающих в список промо-акции.
     */
    double promoSum(String[] promoArticles) {
        double sum = 0;
        for (Item item : items) {
            for (String promoArticle : promoArticles) {
                if (item.getItemsArticle().equals(promoArticle)) {
                    sum += Math.round(item.getItemsQuantity() * item.getItemsPrice() * 100) / 100.0;
                    break;
                }
            }
        }
        return sum;
    }
}
