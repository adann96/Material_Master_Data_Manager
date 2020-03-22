package com.mmdmanager.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        String transaction_admin_name = request.getParameter("transactions");

        try {
            if (transaction_admin_name.toLowerCase().equals("/user")) {
                response.sendRedirect("http://localhost:8090/MMDManager/index.jsp");
            }
            else {
                response.sendRedirect("http://localhost:8090/MMDManager/AdminLogin.jsp");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
