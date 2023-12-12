package Hometask_2.Task3_2;

public class Moving extends Shipment{
    private String movingStorage; // название склада получения (только для перемещения)
    private String movingStorageOwner; // владелец склада получения (только для перемещения)

    public Moving(String storage, String storageOwner, Item[] items, String movingStorage, String movingStorageOwner){
        super(storage, storageOwner, items);
        this.movingStorage = movingStorage;
        this.movingStorageOwner = movingStorageOwner;
    }

    public String getMovingStorage() {
        return movingStorage;
    }
    public void setMovingStorage(String movingStorage) {
        this.movingStorage = movingStorage;
    }

    public String getMovingStorageOwner() {
        return movingStorageOwner;
    }
    public void setMovingStorageOwner(String movingStorageOwner) {
        this.movingStorageOwner = movingStorageOwner;
    }

    /**
     * Является ли перемещение внутренним (между складами одного владельца).
     * Для продаж неприменимо!
     */
    boolean isInternalMovement() {
        return super.getStorage().equals(movingStorageOwner);
    }
}
