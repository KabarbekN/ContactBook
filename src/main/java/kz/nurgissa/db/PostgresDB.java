package kz.nurgissa.db;

import kz.nurgissa.db.interfaces.IDB;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@Slf4j
public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/ContactBook";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, "postgres", "0000");
            return con;
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
