package kz.nurgissa.db;

import kz.nurgissa.db.interfaces.IDB;

import java.sql.Connection;

public class MySQLDB implements IDB {
    @Override
    public Connection getConnection() {
        return null;
    }
}
