package Hometask_2.Task3_2;

public class Sale extends Shipment{
    private String customer; // получатель (только для продажи)

    public Sale(String storage, String storageOwner, Item[] items, String customer){
        super(storage, storageOwner, items);
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * Является ли продажа оптовой для переданного минимального объема.
     */
    boolean isWholesale(double minQuantity) {
        double sumQuantity = 0;
        for (int i = 0; i < super.getItems().length; i++) {
            if (super.getItems()[i].getItemsQuantity() >= minQuantity) {
                return true;
            }
            sumQuantity += super.getItems()[i].getItemsQuantity();
        }
        return sumQuantity >= minQuantity;
    }
}
