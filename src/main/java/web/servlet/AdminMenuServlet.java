package web.servlet;

import entity.History;
import entity.User;
import service.CalcService;
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
    CalcService calcService = new CalcService();

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
        String operation = req.getParameter("operation");
        String userId = req.getParameter("userId");
        service.useAdminMenu(operation, userId);
        LinkedList<User> users = service.findAllUsersJdbc();
        LinkedList<History> results = calcService.select(Integer.parseInt(userId));
        int id = Integer.parseInt(userId);
        req.setAttribute("results", results);
        req.getSession().setAttribute("users", users);
        req.setAttribute("userid", id);
        req.setAttribute("operation", operation);
        getServletContext().getRequestDispatcher("/pages/adminMenu.jsp").forward(req, resp);
    }
}
