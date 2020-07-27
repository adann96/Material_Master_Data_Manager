package com.mmdmanager.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession httpSession = request.getSession(false);
            if (httpSession != null) {
                httpSession.removeAttribute("listLogons");
                httpSession.removeAttribute("listUsers");
                response.sendRedirect("index.jsp");
            }
        }
        catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}