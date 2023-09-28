package ua.ishop.trofimov.controller.RegisterAndLogin;

import org.apache.log4j.Logger;
import ua.ishop.trofimov.factory.UserServiceFactory;
import ua.ishop.trofimov.model.User;
import ua.ishop.trofimov.service.UserService;
import ua.ishop.trofimov.util.HashUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UserLoginServlet.class);
    private static final UserService userService = UserServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(30);

        logger.info("User has login" + session.getId());

        Integer count = (Integer) session.getAttribute("count");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordEncoded;
        try {
            passwordEncoded = HashUtils.getSHA256SecurePassword(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        User currentUser = userService.getUserByEmail(email);
        try{
            if (currentUser != null && currentUser.getPassword().equals(passwordEncoded)) {
                session.setAttribute("user", currentUser);
                req.getRequestDispatcher("/main_admin_page.jsp").forward(req, resp);
            } else if (currentUser == null || currentUser.getPassword() != passwordEncoded) {
                if (count == null) {
                    session.setAttribute("count", 1);
                    count = 1;
                }else if (count >= 5) {
                    resp.sendRedirect("https://www.google.com/");
                }
                else {
                    session.setAttribute("count", ++count);
                    req.setAttribute("error", "You have mistake in your email or password!");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            }
        }catch(Exception e){
            req.setAttribute("error", "You have mistake in your email or password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}
