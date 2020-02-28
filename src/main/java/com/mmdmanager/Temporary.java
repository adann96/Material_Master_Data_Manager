package com.mmdmanager;

public class Temporary {
}
/*
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

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","MMDMANAGER","NHY67ujm");
            statementCreation = connection.createStatement();
            receivedPersData = statementCreation.executeQuery("SELECT * FROM USERS WHERE
                    COMPANY_NAME='" + company_name + "'
                    AND USER_ID='" + user_id + "'
                    AND KOLUMNAZHASLEM='" + acc_password + "'
                    AND IS_ADMIN='" + admin + "';");

            do {
                if (receivedPersData.next()) {
                    response.sendRedirect("MaterialCreator.jsp");
                }
                else if (!(receivedPersData.getString().equals(company_name)) || !(receivedPersData.getString().equals(admin)) || !(receivedPersData.getString().equals(user_id)) && receivedPersData.getString().equals(acc_password)) {
                    //alerta się zrobi, tzn. okienko się uruchomi z napisem "Wrong credentials!", formularz się wyczyści, nie będzie iteracji, bo UserID i Password jest ok
                    //https://stackoverflow.com/questions/24176684/how-to-show-alert-in-a-jsp-from-a-servlet-and-then-redirect-to-another-jsp
                }
                else if (receivedPersData.getString().equals(company_name) && receivedPersData.getString().equals(admin) && receivedPersData.getString().equals(user_id) && !(receivedPersData.getString().equals(acc_password))) {
                    //też alert jsowy, który tym razem pokaże, że jest złe hasło
                    //jak jest złe hasło, a wszystko pozostałe ok, to rozpoczynamy iterację
                    i+=1;
                    if (i == 3) {
                        //Też wyjebie alert, że trzy razy źle wpisane hasło
                        //Przy okazji też skasuje ziomkowi konto, w sumie tu można emaila jebnąć do admina też taki i taki użytkownik został skasowany.
                    }
                }
                else {
                    //alerta się zrobi, tzn. okienko się uruchomi z napisem "Wrong credentials!", formularz się wyczyści, nie będzie iteracji
                    //https://stackoverflow.com/questions/24176684/how-to-show-alert-in-a-jsp-from-a-servlet-and-then-redirect-to-another-jsp
                }
            } while (!(receivedPersData.getString().equals(company_name)) || !(receivedPersData.getString().equals(admin)) || !(receivedPersData.getString().equals(user_id)) ||!(receivedPersData.getString().equals(acc_password)));
        }
        catch (ServletException servletEx) {
            System.out.println("Wrong credentials!");
        }

		/*
        if (company_name.equals("Infosys Consulting") && user_id.toLowerCase().equals("EU5454") && acc_password.equals("Q@3wertyuiop") && admin.equals("Y")) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user_id", user_id);
            response.sendRedirect("materialCreator.jsp");
        }*/
