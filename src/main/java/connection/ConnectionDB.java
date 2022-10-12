package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/quanlyhocvien?useSSL=false",
                    "root",
                    "123456"
            );
            System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ket noi khong thanh cong");
        }
        return connection;
    }
}

