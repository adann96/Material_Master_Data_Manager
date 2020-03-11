package com.mmdmanager.servlets;

import com.mmdmanager.dao.AdminDAO;
import com.mmdmanager.dao.CompaniesDAO;
import com.mmdmanager.others.Admin;
import com.mmdmanager.others.Companies;

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
    long createdSessionTime;
    AdminDAO adminDAO;
    String admin_id, acc_password;
    Admin admin;

    private static final long serialVersionUID = 1L;
    private CompaniesDAO companiesDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        companiesDAO = new CompaniesDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    private void listComp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Companies> listComp = companiesDAO.listAllCompanies();

        for (Companies comp : listComp) {   // foreach grade in grades
            System.out.print(comp.getCompany_short_name()); // print that grade
        }

        request.setAttribute("listComp", listComp);
        System.out.println();
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
        dispatcher.forward(request, response);
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
                httpSession.setAttribute("createdSessionTime", createdSessionTime);
                createdSessionTime = httpSession.getCreationTime();
                List<Companies> listComp = companiesDAO.listAllCompanies();

                for (Companies comp : listComp) {   // foreach grade in grades
                    System.out.print(comp.getCompany_short_name()); // print that grade
                }

                request.setAttribute("listComp", listComp);
                response.sendRedirect("AdminDashboard.jsp?name="+admin_id.toLowerCase()+"?t="+createdSessionTime);
            }
            else if (admin!=null && admin.getUser_id()!=null) {
                response.sendRedirect("None");
            }
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listComp(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}