package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {

    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:Mysql://127.0.0.1:3306/control?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false", "root","root");
        return connection;
    }
}
