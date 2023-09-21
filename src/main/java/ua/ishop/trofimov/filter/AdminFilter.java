package ua.ishop.trofimov.filter;

import ua.ishop.trofimov.model.Role;
import ua.ishop.trofimov.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        User userFromSession = (User) httpServletRequest.getSession().getAttribute("user");
        if (userFromSession != null) {
            List<Role> listRole = userFromSession.getRole();
            if (listRole != null && !listRole.isEmpty()) {
                Role admin = listRole.stream().filter(role -> role.getName().equals("admin")).findFirst().orElse(null);
                if (admin != null) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }else{
                    httpServletResponse.sendRedirect("/login");
                }
            }
        }else{
            httpServletResponse.sendRedirect("/login");
        }
    }
}
