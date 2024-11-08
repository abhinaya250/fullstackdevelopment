package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class hello extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.html");
            return;
        }

        String uname = (String) session.getAttribute("username");
        Date loginTime = (Date) session.getAttribute("loginTime");
        Date currentTime = new Date();
       

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Welcome " + uname + "</title>");
        out.println("<style>");
        out.println("body {font-family: Arial, sans-serif;}");
        out.println(".logout-btn {position: absolute; top: 50px; right: 10px;}");
         out.println(".logout {position: absolute; top: 10px; right: 10px;}");
       
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome, " + uname + "!</h1>");
        out.println("<p class='logout'>Start Time: " + loginTime.toString() + "</p><br>");
   
        out.println("<form action='logout' method='post'>");
        out.println("<button class='logout-btn'>logout</button <br><br>>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Hello Page Servlet";
    }
}
