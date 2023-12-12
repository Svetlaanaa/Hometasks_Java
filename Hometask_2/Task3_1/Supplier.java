package Hometask_2.Task3_1;

public class Supplier {
    private String manufacturerInn;
    private String manufacturerName;
    private String manufacturerAddress;

    public Supplier(String manufacturerInn, String manufacturerName, String manufacturerAddress){
        this.manufacturerInn = manufacturerInn;
        this.manufacturerName = manufacturerName;
        this.manufacturerAddress = manufacturerAddress;
    }

    public void setManufacturerInn(String manufacturerInn){
        this.manufacturerInn = manufacturerInn;
    }
    public String getManufacturerInn(){
        return manufacturerInn;
    }

    public void setManufacturerName(String manufacturerName){
        this.manufacturerName = manufacturerName;
    }
    public String getManufacturerName(){
        return manufacturerName;
    }

    public void setManufacturerAddress(String manufacturerAddress){
        this.manufacturerAddress = manufacturerAddress;
    }
    public String getManufacturerAddress(){
        return manufacturerAddress;
    }
}
