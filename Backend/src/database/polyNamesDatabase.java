package database;
import java.sql.SQLException;

public class polyNamesDatabase extends MySQLDatabase{
    public polyNamesDatabase(String host, int port, String databaseName, String user, String password) throws SQLException {
        super(host, port, databaseName, user, password);
    }
}
