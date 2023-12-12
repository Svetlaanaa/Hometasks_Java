package Hometask_2.Task3_1;

public class Product {
    private String vendorCode;
    private String productName;
    private double manufacturerPrice;
    private Supplier supplier;

    public Product(String vendorCode, String productName, double manufacturerPrice, Supplier supplier){
        this.vendorCode = vendorCode;
        this.productName = productName;
        this.manufacturerPrice = manufacturerPrice;
        this.supplier = supplier;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }
    public String getVendorCode() {
        return vendorCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }

    public void setManufacturerPrice(double manufacturerPrice) {
        this.manufacturerPrice = manufacturerPrice;
    }
    public double getManufacturerPrice() {
        return manufacturerPrice;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public Supplier getSupplier() {
        return supplier;
    }
}
