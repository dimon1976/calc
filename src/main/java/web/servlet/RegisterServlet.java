package web.servlet;

import entity.User;
import service.imp.MemoryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final MemoryService memoryOperation = new MemoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!memoryOperation.register(new User(name, username, password))) {
            resp.getWriter().println("This login exists");
        } else {
            resp.getWriter().println("Are you registered. Please log in.");
        }
    }
}
