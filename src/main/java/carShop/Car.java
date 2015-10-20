package carShop;

/**
 * Created by employee on 10/20/15.
 */
public class Car {

    private String brand;
    private String name;
    private String cost;

    public Car(String brand, String name, String cost) {
        this.brand = brand;
        this.name = name;
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }
}
