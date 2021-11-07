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
import java.util.LinkedList;

@WebServlet("/adminmenu")
public class AdminMenuServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            getServletContext().getRequestDispatcher("/pages/adminMenu.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String operation = req.getParameter("operation");
        String userId = req.getParameter("userId");
        LinkedList<User> users = (LinkedList<User>) session.getAttribute("users");
        service.useAdminMenu(operation, userId, users);
        getServletContext().getRequestDispatcher("/pages/adminMenu.jsp").forward(req, resp);
    }
}
