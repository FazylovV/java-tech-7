package org.example.servlet;

import org.example.model.User;
import org.example.service.AccountService;
import org.example.service.PathUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");

        if (email.isEmpty() || login.isEmpty() || pass.isEmpty()) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Отсутсвует email, логин или пароль");
            return;
        }

        User data = new User(login, pass, email);
        if (AccountService.getUserByLogin(login) == null) {
            AccountService.addNewUser(data);

            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("pass", pass);

            File folder = new File("C:/Users/vladi/users", login);
            boolean isCreationSuccess = true;

            if (new File(folder.getParent()).exists()) {
                if (!folder.exists()) {
                    isCreationSuccess = folder.mkdir();
                }
            } else {
                isCreationSuccess = folder.mkdirs();
            }


            if (!isCreationSuccess) {
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().println("Случилась ошибка при создании папки, попробуйте ещё раз");
                return;
            }

            String currentURL = req.getRequestURL().toString();
            resp.sendRedirect(PathUtility.createRedirectUrl(currentURL, "/files"));
        } else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Пользователь с таким логином уже есть в системе");
        }
    }
}
