package web.servlet;

import entity.User;
import service.imp.CalcService;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalcServlet", value = "/CalcServlet")
public class CalcServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operation = req.getParameter("operation");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        resp.getWriter().println("Result: " + CalcService.start(Double.parseDouble(num1), Double.parseDouble(num2), operation, user) + "\n");
        resp.getWriter().println("Operations history:");
        printHistoryMath(resp, user);
    }

    public void printHistoryMath(HttpServletResponse resp, User user) {
        for (Double numbers : user.getResultList()) {
            try {
                resp.getWriter().println(numbers);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
