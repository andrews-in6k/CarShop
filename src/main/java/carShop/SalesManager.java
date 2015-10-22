package carShop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/20/15.
 */
public class SalesManager {
    private List<Deal> deals = new ArrayList<>();
    private String name;
    private String surname;

    public SalesManager(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addDeal(Deal deal) {
        deals.add(deal);
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return String.format("SalesManager{%s %s}", name, surname);
    }
}
