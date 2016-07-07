package home.week8.servlet;

import home.week8.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alex on 05.07.2016.
 */
@WebServlet(urlPatterns = {"/user/info"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", new User(1, "Oleg", 2500));

        req.getRequestDispatcher("/WEB-INF/pages/user-info.jsp").forward(req, resp);
    }
}
