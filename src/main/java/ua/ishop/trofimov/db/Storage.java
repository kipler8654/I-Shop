package ua.ishop.trofimov.db;

import ua.ishop.trofimov.model.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<User> users = new ArrayList<>() {{
        add(new User(1L,"adfd130@gmail.com", "123"));
        add(new User(2L, "a@gmail.com", "123"));
    }};

    public static void addUser(User user) {
        if (user != null) {
            users.add(user);
        }
    }

    public static List<User> getUsers() {
        return users;
    }

    public static User getUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }
}