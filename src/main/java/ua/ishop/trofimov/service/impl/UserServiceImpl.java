package ua.ishop.trofimov.service.impl;

import org.apache.log4j.Logger;
import ua.ishop.trofimov.dao.UserDao;
import ua.ishop.trofimov.dao.impl.UserDaoImpl;
import ua.ishop.trofimov.factory.UserDaoFactory;
import ua.ishop.trofimov.model.User;
import ua.ishop.trofimov.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private static final UserDao userDao = UserDaoFactory.getInstance();

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }
}
