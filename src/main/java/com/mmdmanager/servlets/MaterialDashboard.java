package com.mmdmanager.servlets;

import com.mmdmanager.dao.SessionDAO;
import com.mmdmanager.others.Session;
import com.mmdmanager.others.User;
import com.mmdmanager.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/MaterialDashboard")
public class MaterialDashboard extends HttpServlet {
    private UserDAO userDAO;
    private SessionDAO sessionDAO;

    private String company_id, user_id, acc_password;

    public Session session;
    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

        try {
            userDAO = new UserDAO();
            sessionDAO = new SessionDAO();

            company_id = request.getParameter("client");
            user_id = request.getParameter("userID");
            acc_password = request.getParameter("userPassword");

            user_id = user_id.toUpperCase();
            user = userDAO.getUser(company_id, user_id, acc_password);

            if (user!=null && (user.getCompany_id()!=null && user.getUser_id()!=null && user.getAcc_password()!=null)) {
                HttpSession httpSession = request.getSession();

                httpSession.setAttribute("user_id", user_id);
                httpSession.setAttribute("createdSessionTime", httpSession.getCreationTime());
                session = sessionDAO.startSession(user_id);

                response.sendRedirect("MaterialDashboard.jsp?name="+user_id.toLowerCase()+"?t="+httpSession.getCreationTime()+"");
            }
            else if (user!=null && (user.getCompany_id()!=null && user.getUser_id()!=null)) {
                response.sendRedirect("None");
            }
            company_id = "";
            user_id="";
            acc_password="";
        }
        catch (NullPointerException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}