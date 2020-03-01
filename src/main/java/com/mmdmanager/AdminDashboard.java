package com.mmdmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/AdminDashboard")
public class AdminDashboard extends HttpServlet {
    long createdSessionTime;
    int i = 0;
    Connection connection;
    Statement statementCreation;
    ResultSet receivedPersonalData;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        String admin_id = request.getParameter("userID");
        String acc_password = request.getParameter("userPassword");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "mmdmanager", "NHY67ujm");
            statementCreation = connection.createStatement();
            receivedPersonalData = statementCreation.executeQuery("SELECT COMPANY_NAME, USER_ID, ACC_PASSWORD, IS_ADMIN, FIRST_NAME, LAST_NAME, SEX FROM USERS WHERE USER_ID='" + admin_id + "' " + "AND ACC_PASSWORD='" + acc_password + "' AND IS_ADMIN = 'Y'");

            if (receivedPersonalData.next()) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("admin_id", admin_id);
                httpSession.setAttribute("createdSessionTime", createdSessionTime);
                createdSessionTime = httpSession.getCreationTime();
                response.sendRedirect("AdminDashboard.jsp?name="+admin_id.toLowerCase()+"?t="+createdSessionTime+"");
            }
            else {
                response.sendRedirect("http://localhost:8090/Login/index.jsp");
            }
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
