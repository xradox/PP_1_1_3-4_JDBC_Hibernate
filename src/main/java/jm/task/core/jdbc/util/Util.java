package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/rest", "root", "root");
    }
}
