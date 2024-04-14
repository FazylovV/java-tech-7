package org.example.servlet;

import org.example.model.FileElement;
import org.example.service.AccountService;
import org.example.service.FileService;
import org.example.service.PathUtility;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/files")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String login = (String) req.getSession().getAttribute("login");
        String pass = (String) req.getSession().getAttribute("pass");

        if (AccountService.getUserByLogin(login) == null || !AccountService.getUserByLogin(login).getPassword().equals(pass)) {
            String currentURL = req.getRequestURL().toString();
            resp.sendRedirect(PathUtility.createRedirectUrl(currentURL, "/log"));
            return;
        }

        String pathToUserDir = "C:/Users/vladi/users/" + login;
        String pathFromRequest = req.getParameter("path");
        if (req.getParameter("path") != null) {
            pathFromRequest = pathFromRequest.replace('\\', '/');
            if (!pathFromRequest.startsWith(pathToUserDir)) {
                pathFromRequest = pathToUserDir;
            }
        } else {
            pathFromRequest = pathToUserDir;
        }

        req.setAttribute("currentDir", pathFromRequest);
        req.setAttribute("list",
                FileService.getElements(new File(pathFromRequest)));

        String parentDirPath = new File(pathFromRequest).getParent();
        if (parentDirPath == null) {
            parentDirPath = pathFromRequest;
        }
        req.setAttribute("parentDirPath", parentDirPath);

        Date generationDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

        req.setAttribute("generationTime", dateFormat.format(generationDate));
        req.getRequestDispatcher("mypage.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws IOException {

        httpServletRequest.getSession().removeAttribute("login");
        httpServletRequest.getSession().removeAttribute("pass");
        String currentURL = httpServletRequest.getRequestURL().toString();
        httpServletResponse.sendRedirect(PathUtility.createRedirectUrl(currentURL, "/"));
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
    }
}
