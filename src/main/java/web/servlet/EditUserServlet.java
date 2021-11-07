package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "edit", value = "/edit")
public class EditUserServlet extends HttpServlet {
UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/pages/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        service.editUserJdbc(user,name, username, password);
        req.setAttribute("message", "User updated");
        resp.sendRedirect("/");
//        getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}
