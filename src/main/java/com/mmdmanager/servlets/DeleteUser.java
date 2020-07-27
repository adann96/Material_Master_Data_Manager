package com.mmdmanager.servlets;

import com.mmdmanager.dao.UserDAO;
import com.mmdmanager.others.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
    boolean rowToBeDeleted;
    UserDAO userDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        String encodedRedirectURL = response.encodeRedirectURL("AdminDashboard.jsp");

        String user_id = request.getParameter("deleteUser");
        userDAO = new UserDAO();

        try {
            rowToBeDeleted = userDAO.deleteUserfromDb(user_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        request.getRequestDispatcher(encodedRedirectURL).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
