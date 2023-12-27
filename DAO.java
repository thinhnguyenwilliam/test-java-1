package laptrinhdidong_hcmus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    protected static Connection ket_noi;

    public DAO() {
        String url = "jdbc:mysql://localhost:3306/test_buoi_1?autoReconnect=true&useSSL=false";
        String username = "root";  // Replace with actual username
        String password = "1234";  // Replace with actual password

        if (ket_noi == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                ket_noi = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to the database.");
            } catch (ClassNotFoundException | SQLException ex) {
                // Handle the exception appropriately (e.g., log the error)
                ex.printStackTrace();
            }
        }
    }

    public void closeConnection() {
        if (ket_noi != null) {
            try {
                ket_noi.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                // Handle the exception appropriately (e.g., log the error)
                e.printStackTrace();
            }
        }
    }
    
//    public static void main(String[] args)
//    {
//        new DAO();
//    }

}
