package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try(Connection connection = Util.getMySQLConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("Create table Users(id integer AUTO_INCREMENT NOT NULL PRIMARY KEY , name varchar(100), lastName varchar(100), age integer)");
        } catch (SQLException | ClassNotFoundException ignore) {
        }
    }

    public void dropUsersTable() {
        try(Connection connection = Util.getMySQLConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Users");
        } catch (SQLException | ClassNotFoundException ignore) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Connection connection = Util.getMySQLConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Users(name, lastName, age) VALUES ('" + name + "', '" + lastName + "', '" + age +"')");
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException | ClassNotFoundException ignore) {
        }
    }

    public void removeUserById(long id) {
        try(Connection connection = Util.getMySQLConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Users WHERE id = " + id);
        } catch (SQLException | ClassNotFoundException ignore) {
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try(Connection connection = Util.getMySQLConnection()){
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM Users");
            while (set.next()) {
                User user = new User();
                user.setId((long)set.getInt(1));
                user.setName(set.getString(2));
                user.setLastName(set.getString(3));
                user.setAge((byte)set.getInt(4));
                list.add(user);
            }
        } catch (SQLException | ClassNotFoundException ignore) {
        }
        return list;
    }

    public void cleanUsersTable() {
        try(Connection connection = Util.getMySQLConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE Users");
        } catch (SQLException | ClassNotFoundException ignore) {
        }
    }
}
