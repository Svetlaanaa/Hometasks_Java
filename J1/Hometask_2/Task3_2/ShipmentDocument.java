package Hometask_2.Task3_2;

import java.util.Date;
import java.util.UUID;

public class ShipmentDocument {
    private UUID documentId; // GUID документа
    private Date documentDate; // дата документа
    private Shipment shipment; // отгрузка

    public ShipmentDocument(UUID documentId, Date documentDate, Shipment shipment){
        this.documentId = documentId;
        this.documentDate = documentDate;
        this.shipment = shipment;
    }

    public UUID getDocumentId() {
        return documentId;
    }
    public void setDocumentId(UUID documentId) {
        this.documentId = documentId;
    }

    public Date getDocumentDate() {
        return documentDate;
    }
    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public Shipment getShipment() {
        return shipment;
    }
    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    /**
     * Суммарная стоимость товаров в документе.
     */
    public double totalAmount(){
        double sum = 0;
        for (int i = 0; i < shipment.getItems().length; i++) {
            sum += Math.round(shipment.getItems()[i].getItemsQuantity() * shipment.getItems()[i].getItemsPrice() * 100) / 100.0;
        }
        return sum;
    }
}
