package web.filter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(/*servletNames = {"calc"}*/)
public class FilterNumber extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if("GET".equals(req.getMethod())){
            String num1 = req.getParameter("num1");
            String num2 = req.getParameter("num2");
            String operation = req.getParameter("operation");
            extracted(req, resp, chain, num1, num2, operation);
        }else if("POST".equals(req.getMethod())){
            String num1 = req.getParameter("num1");
            String num2 = req.getParameter("num2");
            String operation = req.getParameter("operation");
            extracted(req, resp, chain, num1, num2, operation);
        }

    }

    private void extracted(HttpServletRequest req, HttpServletResponse resp, FilterChain chain, String num1, String num2, String operation) throws IOException, ServletException {
        if (isNumeric(num1)) {
            if (isNumeric(num2)) {
                if (checkString(operation)) {
                    chain.doFilter(req, resp);
                } else {
                    resp.getWriter().println(operation + " Error, write one of the values to the parameter:\n" +
                            "sum\ndiv\nsubtrack\nmultiply");
                }
            } else {
                resp.getWriter().println("Parameter '" + num2 + "' not number.");
            }
        } else {
            resp.getWriter().println("Parameter '" + num1 + "' not number.");
        }
    }


    private static boolean checkString(String str) {
        return str.equals("sum") || str.equals("div") || str.equals("subtrack") || str.equals("multiply");
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
