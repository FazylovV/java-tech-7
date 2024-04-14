package org.example.servlet;


import org.example.model.User;
import org.example.service.AccountService;
import org.example.service.PathUtility;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req,
                       HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");

        if (login.isEmpty() || pass.isEmpty()) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Отсутсвует логин или пароль");
            return;
        }

        User data = AccountService.getUserByLogin(login);
        if (data == null || !data.getPassword().equals(pass)) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Неправильный логин или пароль");
            return;
        }

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("pass", pass);

        String currentURL = req.getRequestURL().toString();
        resp.sendRedirect(PathUtility.createRedirectUrl(currentURL, "/files"));
    }
}
