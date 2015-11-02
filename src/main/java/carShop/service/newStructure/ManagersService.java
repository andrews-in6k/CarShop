package carShop.service.newStructure;

import carShop.core.dao.ManagerDAO;
import carShop.core.entity.Manager;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public class ManagersService implements ManagersServiceInterface{

    private ManagerDAO managerDAO;

    public ManagersService(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @Override
    public void addManager(Manager manager) {
        managerDAO.save(manager);
    }

    @Override
    public void removeManager(Manager manager) {
        managerDAO.delete(manager);
    }

    @Override
    public List<Manager> getManagers() {
        return managerDAO.getTableRows();
    }

    @Override
    public Manager getManagerById(int id) {
        return managerDAO.getManagerById(id);
    }
}
