package Hometask_2.Task3_1;

public class Dealer extends Supplier {
    private Manufacturer manufacturer;
    private double markup;

    public Dealer(String providerInn, String providerName, String providerAddress, Manufacturer manufacturer, double markup) {
        super(providerInn, providerName, providerAddress);
        this.manufacturer = manufacturer;
        this.markup = markup;
    }


    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }
    public double getMarkup() {
        return markup;
    }
}
