package carDealership;

public class Vehicle {

    private int price;
    private String make;
    private String model;
    private String type;

    public Vehicle(int price, String make, String model, String type) {
        this.price = price;
        this.make = make;
        this.model = model;
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
