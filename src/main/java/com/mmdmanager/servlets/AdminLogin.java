package com.mmdmanager.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        String transaction_user_name = request.getParameter("transactions");

        try {
            if (transaction_user_name.toLowerCase().equals("/admin")) {
                response.sendRedirect("AdminLogin.jsp");
            }
            else {
                response.sendRedirect("http://localhost:8090/Login/index.jsp");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
