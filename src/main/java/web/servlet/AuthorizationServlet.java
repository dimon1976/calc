package web.servlet;

import storage.InMemoryStorage;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/authorize")
public class AuthorizationServlet extends HttpServlet {
    private final InMemoryStorage storage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = storage.findByUsername(username);
        verificationPassword(req, resp, password, user);
    }

    private void verificationPassword(HttpServletRequest req, HttpServletResponse resp, String password, User user) throws IOException {
        if (user != null) {
            if (user.getPass().equals(password)) {
                req.getSession().setAttribute("user", user);
                resp.getWriter().println("You are logged in");
            } else {
                resp.getWriter().println("Wrong password");
            }
        } else {
            resp.getWriter().println("User not found");
        }
    }
}
