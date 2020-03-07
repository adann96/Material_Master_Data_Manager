package com.mmdmanager.servlets;

import com.mmdmanager.others.User;
import com.mmdmanager.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/MaterialDashboard")
public class MaterialDashboard extends HttpServlet {
    long createdSessionTime;
    UserDAO userDAO;
    String company_id, user_id, acc_password;
    User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

        try {
            userDAO = new UserDAO();

            company_id = request.getParameter("client");
            user_id = request.getParameter("userID");
            acc_password = request.getParameter("userPassword");

            user_id = user_id.toUpperCase();

            user = userDAO.getUser(company_id, user_id, acc_password);

            if (user!=null && (user.getCompany_id()!=null && user.getUser_id()!=null && user.getAcc_password()!=null)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user_id", user_id);
                httpSession.setAttribute("createdSessionTime", createdSessionTime);
                createdSessionTime = httpSession.getCreationTime();
                response.sendRedirect("MaterialDashboard.jsp?name="+user_id.toLowerCase()+"?t="+createdSessionTime+"");
            }
            else if (user!=null && (user.getCompany_id()!=null && user.getUser_id()!=null)) {
                response.sendRedirect("None");
            }
        }
        catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}