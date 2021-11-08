package web.servlet;

import service.UserService;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;


@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    private final UserService storageService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = storageService.findByUsername(username);
        verificationPassword(req, resp, password, user);
    }

    private void verificationPassword(HttpServletRequest req, HttpServletResponse resp, String password, User user) throws IOException, ServletException {
        if (user != null) {
            if (user.getPass().equals(password)) {
                LinkedList<User> users = storageService.findAllUsers();
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("users", users);
                resp.sendRedirect("/");
                return;
            } else {
                req.setAttribute("message", "Wrong password");
            }
        } else {
            req.setAttribute("message", "User not found");
        }
        getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
    }
}
