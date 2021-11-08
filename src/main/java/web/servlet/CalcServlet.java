package web.servlet;

import entity.History;
import entity.User;
import service.CalcService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

@WebServlet(name = "calc", value = "/calc")
public class CalcServlet extends HttpServlet {
    CalcService service = new CalcService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);

//        resp.getWriter().println("Operations history:");
//        printHistoryMath(resp, user);
    }

//    public void printHistoryMath(HttpServletResponse resp, User user) {
//        for (Double numbers : user.getResultList()) {
//            try {
//                resp.getWriter().println(numbers);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operation = req.getParameter("operation");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Double result = service.start(Double.parseDouble(num1), Double.parseDouble(num2), operation, user);
        LinkedList<History> results = service.select(user.getId());
        req.setAttribute("results",results);
        req.setAttribute("message", result);
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}
