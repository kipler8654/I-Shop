package ua.ishop.trofimov.controller.Users;


import org.apache.log4j.Logger;
import ua.ishop.trofimov.factory.UserServiceFactory;
import ua.ishop.trofimov.model.User;
import ua.ishop.trofimov.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/users/add")
public class AddUserServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AddUserServlet.class);
    private static final UserService userService = UserServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add_user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(email, password);
        userService.addUser(user);
        resp.sendRedirect("/admin/users");
        //req.getRequestDispatcher("/users").forward(req, resp);
    }
}
