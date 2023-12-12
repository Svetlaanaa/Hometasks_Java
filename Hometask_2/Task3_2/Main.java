package Hometask_2.Task3_2;

import java.util.Date;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Item[] items = {
                new Item(UUID.randomUUID(), "121212121", "sdfg", 5, 1213.3),
                new Item(UUID.randomUUID(), "345676543", "sdfghj", 5, 318)
        };
        Sale sale = new Sale("S1", "V1", items, "P1");
        System.out.println(sale.isWholesale(2));
        System.out.println(sale.isWholesale(11));

        Moving moving = new Moving("M1", "V1", items, "M1", "V2");
        System.out.println("Суммарная стоимость товаров, попадающих в список промо-акции " + moving.promoSum(new String[]{"121212121"}));
        System.out.println("Стоимость товара с переданным id " + moving.itemAmount(items[1].getItemsId()));
        System.out.println("Является ли перемещение внутренним " + moving.isInternalMovement());

        ShipmentDocument doc = new ShipmentDocument(UUID.randomUUID(), new Date(), sale);
        System.out.println("Суммарная стоимость товаров в документе " + doc.totalAmount());
    }
}
