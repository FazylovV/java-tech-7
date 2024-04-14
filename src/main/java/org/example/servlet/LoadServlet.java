package org.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/load")
public class LoadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String currentFilePath = req.getParameter("path");
        try (FileInputStream fileInputStream = new FileInputStream(currentFilePath)) {

            resp.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(new File(currentFilePath).getName(),
                    StandardCharsets.UTF_8.toString()) + "\"");

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                resp.getOutputStream().write(buffer, 0, bytesRead);
            }
        }
    }
}
