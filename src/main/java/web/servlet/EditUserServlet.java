package web.servlet;

import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "edit", value = "/edit")
public class EditUserServlet extends HttpServlet {
    RegisterServlet registerServlet = new RegisterServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        registerServlet.getMemoryOperation().editUser(user, name, username, password);
        resp.getWriter().println("User updated");
    }
}
