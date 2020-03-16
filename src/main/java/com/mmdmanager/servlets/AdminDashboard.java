package com.mmdmanager.servlets;

import com.mmdmanager.dao.AdminDAO;
import com.mmdmanager.dao.CompaniesDAO;
import com.mmdmanager.dao.SessionDAO;
import com.mmdmanager.others.Admin;
import com.mmdmanager.others.Companies;
import com.mmdmanager.others.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AdminDashboard")
public class AdminDashboard extends HttpServlet {
    private static final long serialVersionUID = 1;
    long createdSessionTime;

    private CompaniesDAO companiesDAO;
    private AdminDAO adminDAO;

    private String admin_id, acc_password;
    private Admin admin;

    private String redirection = "AdminDashboard.jsp";

    public void init() {
        companiesDAO = new CompaniesDAO();
    }

    private void listCompanies(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession httpSession = request.getSession();
        List<Companies> listCompanies = companiesDAO.allCompanies();
        httpSession.setAttribute("listCompanies", listCompanies);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        adminDAO = new AdminDAO();

        admin_id = request.getParameter("userID");
        acc_password = request.getParameter("userPassword");

        admin_id = admin_id.toUpperCase();
        admin = adminDAO.getAdmin(admin_id,acc_password);

        try {
            if (admin!=null && (admin.getUser_id()!=null && admin.getAcc_password()!=null)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("admin_id", admin_id);

                try {
                    listCompanies(request,response);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }

                httpSession.setAttribute("createdSessionTime", createdSessionTime);
                createdSessionTime = httpSession.getCreationTime();
                response.sendRedirect(redirection+"?name="+admin_id.toLowerCase()+"?t="+createdSessionTime);
            }
            else if (admin!=null && admin.getUser_id()!=null) {
                response.sendRedirect("None");
            }
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}