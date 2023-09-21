package ua.ishop.trofimov.controller.RegisterAndLogin;

import ua.ishop.trofimov.factory.UserServiceFactory;
import ua.ishop.trofimov.model.User;
import ua.ishop.trofimov.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserRegistrationServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rPassword = req.getParameter("rpassword");
        

        if (password.equals(rPassword)) {
            User user = new User(email, password);
            userService.addUser(user);
            resp.sendRedirect("/");
            System.out.println("Мы зарегестрировались");
        }else {
            req.setAttribute("error", "Your password not correct");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }

    }
}
