package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
            String uname = (String) session.getAttribute("username");
            Date loginTime = (Date) session.getAttribute("loginTime");
            Date logoutTime = new Date();

            // Calculate session duration in seconds
            long durationInSeconds = (logoutTime.getTime() - loginTime.getTime()) / 1000;

            // Invalidate the session
            session.invalidate();

            // Display thank you message
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Logout</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Thank You, " + uname + "!</h1>");
            out.println("<p>Your session lasted for: " + durationInSeconds + " seconds</p>");
            out.println("</body>");
            out.println("</html>");
        } else {
            response.sendRedirect("index.html");
        }
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
        return "Logout Servlet";
    }
}
