package com.mmdmanager.servlets;

import com.mmdmanager.dao.ClientDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddClient")
public class AddClient extends HttpServlet {
    boolean rowToBeAdded;
    ClientDAO clientDAO;
    private String company_name, company_short_name, company_country;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

        company_name = request.getParameter("companyName");
        company_short_name = request.getParameter("shortName");
        company_country = request.getParameter("countryName");

        clientDAO = new ClientDAO();

        try {
            rowToBeAdded = clientDAO.addClientToDb(company_name,company_short_name,company_country);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("NewClient.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
