//package mysqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DockerContainer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://bankdatabase.c1uxa5jkd8lj.us-east-2.rds.amazonaws.com:3306/bankDB";
        final String USER = "admin";
        final String PASS = "admin123";

        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating table in given database...");
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE bankDB " +
                    "(account_number VARCHAR(255) not NULL, " +
                    " balance DOUBLE, " +
                    " customer_name VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " phone_number VARCHAR(255), " +
                    " PRIMARY KEY (account_number))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}