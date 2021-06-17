package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {

                return DriverManager.getConnection("jdbc:mysql://188.44.72.209:33062/pearl",
                        "pearl", "pearl2021");
    }

}
