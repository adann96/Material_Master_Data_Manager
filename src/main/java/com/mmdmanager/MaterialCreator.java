package com.mmdmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/MaterialCreator")
public class MaterialCreator extends HttpServlet {
    Connection dbConnection;
    PreparedStatement getCredentialsFromDb;
    ResultSet userCredentialsReceived;
    String userCredentials = "SELECT USER_ID, FIRST_NAME, LAST_NAME, SEX, COMPANY_NAME, IS_ADMIN, ACC_PASSWORD FROM USERS " +
            "WHERE COMPANY_NAME =? AND USER_ID =? AND ACC_PASSWORD =? AND IS_ADMIN =?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        doGet(request,response);
        String company_name = request.getParameter("client");
        String user_id = request.getParameter("userID");
        String acc_password = request.getParameter("userPassword");
        String is_admin = request.getParameter("isAdmin");

        if (company_name.equals("Infosys Consulting") && user_id.equals("ADMIN1") && acc_password.equals("Q@3wertyuiop") && is_admin.equals("Y")) {
            HttpSession httpSession = request.getSession();
            response.sendRedirect("/MaterialCreator.jsp");
        }
        else {
            response.sendRedirect("/None");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

/*
            Class.forName ("oracle.jdbc.driver.OracleDriver");
            dbConnection = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:orcl", "MMDMANAGER", "NHY67ujm");
            getCredentialsFromDb = dbConnection.prepareStatement(userCredentials);

                getCredentialsFromDb.setString(1, company_name);
                getCredentialsFromDb.setString(2, user_id);
                getCredentialsFromDb.setString(3, acc_password);
                getCredentialsFromDb.setString(4, is_admin);

            userCredentialsReceived = getCredentialsFromDb.executeQuery();
*/

