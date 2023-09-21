package ua.ishop.trofimov.factory;

import ua.ishop.trofimov.dao.UserDao;
import ua.ishop.trofimov.dao.impl.UserDaoImpl;
import ua.ishop.trofimov.dao.impl.UserDaoPostgresImpl;

public class UserDaoFactory {
    private static UserDao instance;

    public static synchronized UserDao getInstance() {
        if (instance == null) {
            instance = new UserDaoPostgresImpl();
        }
        return instance;
    }
}