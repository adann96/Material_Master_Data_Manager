package com.mmdmanager.servlets;

import com.mmdmanager.dao.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
    boolean rowToBeAdded;
    UserDAO userDAO;
    private String user_id, first_name, middle_name, last_name, sex, is_admin, company_id;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

        user_id = request.getParameter("userId");
        first_name = request.getParameter("firstName");
        middle_name = request.getParameter("middleName");
        last_name = request.getParameter("lastName");
        sex = request.getParameter("sex");
        company_id = request.getParameter("company");
        is_admin = request.getParameter("isAdmin");

        userDAO = new UserDAO();

        try {
            rowToBeAdded = userDAO.addUserToDb(user_id,first_name,middle_name,last_name,sex,company_id,is_admin);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("NewUser.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
