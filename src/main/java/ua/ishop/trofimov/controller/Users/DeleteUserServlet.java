package ua.ishop.trofimov.controller.Users;

import org.apache.log4j.Logger;
import ua.ishop.trofimov.factory.UserServiceFactory;
import ua.ishop.trofimov.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/delete")
public class DeleteUserServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DeleteUserServlet.class);
    private static final UserService userService = UserServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("userId"));
        userService.deleteUserById(id);
        resp.sendRedirect("/admin/users");
    }
}
