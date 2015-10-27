package carShop.core.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by employee on 10/23/15.
 */
@Entity
@Table(name = "deal")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "buying_date")
    private Date buyingDate;

    @OneToOne
    @JoinColumn(name = "sold_car_id")
    private Car soldCar;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    public Car getSoldCar() {
        return soldCar;
    }

    public void setSoldCar(Car soldCar) {
        this.soldCar = soldCar;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
