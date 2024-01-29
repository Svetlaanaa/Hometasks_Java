package Hometask_2.Task3_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("1111111111", "Name1", "Address1");
        Manufacturer manufacturer2 = new Manufacturer("2222222222", "Name2", "Address2");
        Manufacturer manufacturer3 = new Manufacturer("3333333333", "Name3", "Address3");

        Dealer dealer1 = new Dealer("1111111110", "Name12",
                "Address12", manufacturer1, 20);
        Dealer dealer2 = new Dealer("2222222220", "Name22",
                "Address22", manufacturer2, 30);
        Product[] products = {
                new Product("010101010101", "платье", 2500, dealer1),
                new Product("020202020202", "джинсы", 3000.99, manufacturer3),
                new Product("030303030303", "шорты", 1500, manufacturer2),
                new Product("040404040404", "футболка", 1000, dealer2),
                new Product("050505050505", "туфли", 4500, manufacturer1),
                new Product("060606060606", "куртка", 6000, dealer2),
                new Product("070707070707", "носки", 200, manufacturer3),
                new Product("080808080808", "платье", 4000, dealer1),
                new Product("090909090909", "кеды", 3500, manufacturer3),
                new Product("101010101010", "шорты", 2500, manufacturer2),
                new Product("111111111111", "футболка", 1203.5, dealer2),
                new Product("121212121212", "туфли", 7000, manufacturer1),
                new Product("131313131313", "куртка", 10000, dealer2),
                new Product("141414141414", "носки", 150, manufacturer3),
                new Product("151515151515", "платье", 3000, dealer1),
        };

        Scanner in = new Scanner(System.in);
        while (true){
            String vendorCode = in.nextLine();
            if(!(vendorCode.matches("\\d+")) & vendorCode.length() <= 15 & vendorCode.length() >= 10){
                System.out.println("Артикул введён неверно");
            }
            else {
                for (int i = 0; i < products.length; i++){
                    if ((products[i].getVendorCode().equals(vendorCode))){
                        System.out.println(products[i].getProductName());

                        double currentPrice = products[i].getManufacturerPrice();
                        boolean supplierIsDealer = products[i].getSupplier() instanceof Dealer;
                        if (supplierIsDealer){
                            currentPrice = Math.round((currentPrice + currentPrice * ((Dealer) products[i].getSupplier()).getMarkup() / 100.0) * 100.0) / 100.0;
                        }
                        System.out.println(currentPrice);

                        System.out.print(products[i].getSupplier().getManufacturerName() + ", "
                                + products[i].getSupplier().getManufacturerAddress());

                        if (supplierIsDealer){
                            System.out.println(" (" + ((Dealer) products[i].getSupplier()).getManufacturer().getManufacturerName() + ")");
                        }
                        break;
                    }
                }
            }
        }


    }
}
