package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String host ="localhost";
    private static final String schema ="for_jm_tasks";
    private static final String user ="root";
    private static final String pass ="61545272Rj";


    public static Connection getMySQLConnection() {
        return getMySQLConnection(host, schema, user, pass);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) {
        Connection connection = null;
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName+
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
