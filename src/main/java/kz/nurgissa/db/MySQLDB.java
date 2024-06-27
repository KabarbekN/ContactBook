package kz.nurgissa.db;

import kz.nurgissa.db.interfaces.IDB;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Slf4j
public class MySQLDB implements IDB {
    @Override
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/contactbook";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, "root", "0000");
            log.info("Connected to database");
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }
}
