package com.mmdmanager.servlets;

import com.mmdmanager.dao.SessionDAO;
import com.mmdmanager.dao.UserDAO;
import com.mmdmanager.others.Session;
import com.mmdmanager.others.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet("/UserLogout")
public class UserLogout extends HttpServlet {
    private long closeSessionTime;
    private SessionDAO sessionDAO;
    public Session session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            sessionDAO = new SessionDAO();
            HttpSession httpSession = request.getSession(false);
            if (httpSession != null) {
                closeSessionTime = httpSession.getLastAccessedTime();
                session = sessionDAO.closeSession(new Timestamp(closeSessionTime));
                httpSession.removeAttribute("user_id");
                httpSession.removeAttribute("createdSessionTime");
                response.sendRedirect("index.jsp");
            }
        }
        catch (NullPointerException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
