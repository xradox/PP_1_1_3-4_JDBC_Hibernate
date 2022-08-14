package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Vova", "Vladimirov", (byte)55);
        userService.saveUser("Pasha", "Pashkov", (byte) 33);
        userService.saveUser("Stepa", "Stepanov", (byte) 22);
        userService.saveUser("Sasha", "Alexandrov", (byte) 44);
        List<User> list = userService.getAllUsers();
        list.forEach(System.out::println);
        userService.cleanUsersTable();
        //userService.dropUsersTable();
    }
}
