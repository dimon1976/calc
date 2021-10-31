package web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(/*servletNames = {"edit"}*/)
public class FilterAttributeUser extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getParameter("name") != null) {
            if (req.getParameter("username") != null) {
                if (req.getParameter("password") != null) {
                    chain.doFilter(req, res);
                }else{
                    res.getWriter().println("Password null!");
                }
            }else{
                res.getWriter().println("Username null!");
            }
        }else{
            res.getWriter().println("Name null!");
        }
    }
}
