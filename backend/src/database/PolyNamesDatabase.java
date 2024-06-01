package database;

import java.sql.SQLException;

public class PolyNamesDatabase extends MySQLDatabase {
    
    public PolyNamesDatabase(String host, int port, String databaseName, String user, String password) throws SQLException {
        super(host, port, databaseName, user, password);
    }
}
