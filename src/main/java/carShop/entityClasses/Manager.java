package carShop.entityClasses;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "id")
    List<Deal> deals = new ArrayList<>();
}
