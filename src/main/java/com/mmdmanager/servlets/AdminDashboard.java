package com.mmdmanager.servlets;

import com.mmdmanager.dao.AdminDAO;
import com.mmdmanager.dao.ClientDAO;
import com.mmdmanager.dao.LogonsDAO;
import com.mmdmanager.dao.UserDAO;
import com.mmdmanager.others.Admin;
import com.mmdmanager.others.Client;
import com.mmdmanager.others.Logons;
import com.mmdmanager.others.User;

import javax.management.MBeanServerConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet("/AdminDashboard")
public class AdminDashboard extends HttpServlet {
    private static final long serialVersionUID = 1;
    private final Date date = new java.util.Date();

    private LogonsDAO logonsDAO;
    private UserDAO userDAO;
    private ClientDAO clientDAO;

    public void init() {
        logonsDAO = new LogonsDAO();
        userDAO = new UserDAO();
        clientDAO = new ClientDAO();
    }

    private void listLogons(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession httpSession = request.getSession();
        List<Logons> listLogons = logonsDAO.allLogons();
        httpSession.setAttribute("listLogons", listLogons);
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession httpSession = request.getSession();
        List<User> listUsers = userDAO.allUsers();
        httpSession.setAttribute("listUsers", listUsers);
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession httpSession = request.getSession();
        List<Client> listClients = clientDAO.allClients();
        httpSession.setAttribute("listClients", listClients);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        AdminDAO adminDAO = new AdminDAO();

        String admin_id = request.getParameter("adminID").toUpperCase();
        String acc_password = request.getParameter("adminPassword");

        try {
            Admin admin = null;
            try {
                admin = adminDAO.getAdmin(admin_id, acc_password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            if (admin !=null && (admin.getUser_id()!=null && admin.getAcc_password()!=null)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("admin_id", admin_id);

                try {
                    listLogons(request,response);
                    listUsers(request,response);
                    listClients(request,response);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                
                String redirection = "AdminDashboard.jsp";
                response.sendRedirect(redirection +"?name="+ admin_id.toLowerCase());
            }
            else if (admin !=null && admin.getUser_id()!=null) {
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