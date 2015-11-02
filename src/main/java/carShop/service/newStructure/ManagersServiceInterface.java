package carShop.service.newStructure;

import carShop.core.entity.Manager;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public interface ManagersServiceInterface {

    void addManager(Manager manager);
    void removeManager(Manager manager);
    List<Manager> getManagers();
    Manager getManagerById(int id);
}
