package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    //private final UserDaoJDBCImpl daoJDBC;
    private final UserDaoHibernateImpl daoHibernate;
    public UserServiceImpl() {
        this.daoHibernate = new UserDaoHibernateImpl();
        //this.daoJDBC = new UserDaoJDBCImpl();
    }

    public void createUsersTable() {
        //daoJDBC.createUsersTable();
        daoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        //daoJDBC.dropUsersTable();
        daoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        //daoJDBC.saveUser(name, lastName, age);
        daoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        //daoJDBC.removeUserById(id);
        daoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        //return daoJDBC.getAllUsers();
        return daoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        //daoJDBC.cleanUsersTable();
        daoHibernate.cleanUsersTable();
    }
}
