package com.mmdmanager.servlets;

import com.mmdmanager.dao.ClientDAO;
import com.mmdmanager.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteClient")
public class DeleteClient extends HttpServlet {
    boolean rowToBeDeleted;
    ClientDAO clientDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

        String client_id = request.getParameter("deleteClient");
        clientDAO = new ClientDAO();

        try {
            rowToBeDeleted = clientDAO.deleteClientFromDb(Byte.parseByte(client_id));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("AdminDashboard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
