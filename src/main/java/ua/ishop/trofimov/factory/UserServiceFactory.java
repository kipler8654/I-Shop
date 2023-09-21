package ua.ishop.trofimov.factory;

import ua.ishop.trofimov.service.UserService;
import ua.ishop.trofimov.service.impl.UserServiceImpl;

public class UserServiceFactory {
    private static UserService instance;

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }
}
