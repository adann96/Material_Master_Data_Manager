package com.mmdmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/MaterialCreator")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        String company_name = request.getParameter("client");
        String user_id = request.getParameter("userID");
        String acc_password = request.getParameter("NHY67ujm");
        String admin = request.getParameter("");

        if (company_name.equals("Infosys Consulting") && user_id.toLowerCase().equals("EU5454") && acc_password.equals("Q@3wertyuiop") && admin.equals("Y")) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user_id", user_id);
            response.sendRedirect("materialCreator.jsp");
        }
    }
}
