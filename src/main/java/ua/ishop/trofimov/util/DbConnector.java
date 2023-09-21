package ua.ishop.trofimov.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static final Logger logger = Logger.getLogger(DbConnector.class);

    private static final String DbURL = "jdbc:postgresql://localhost:5432/I-Shop";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "8654";


    private static DbConnector instance;



    public static Connection getConnection() {
        try {
//          System.setProperty("jdbc.driver", "org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");

            // DbConnector connector = DbConnector.getInstance();
            Connection connection = DriverManager.getConnection(DbURL, LOGIN, PASSWORD);
            logger.debug("connection" + connection);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            //ClassNotFoundException если мы не загрузили библиотеку постгресс и значит не можем подключить библиотеку к нашему джава приложения
            logger.error("no connect to db: " + e);
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
