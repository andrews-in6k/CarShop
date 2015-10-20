package carShop;

/**
 * Created by employee on 10/20/15.
 */
public class Car {

    private String brand;
    private String name;
    private int cost;

    public Car(String brand, String name, int cost) {
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

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
