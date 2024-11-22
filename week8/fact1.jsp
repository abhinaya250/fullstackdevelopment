<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Factorial Calculator</title>
</head>
<body>
    <h1>Factorial Calculator</h1>
    <form method="post" action="fact1.jsp">
        <label for="number">Enter a number:</label>
        <input type="number" id="number" name="number" required>
        <button type="submit">Calculate</button>
    </form>

    <%
        // Get the input number from the form
        String numberStr = request.getParameter("number");
        if (numberStr != null) {
            try {
                int number = Integer.parseInt(numberStr);
                long factorial = 1;

                if (number < 0) {
                    out.println("<p style='color:red;'>Factorial of a negative number is not defined.</p>");
                } else {
                    // Calculate factorial
                    for (int i = 1; i <= number; i++) {
                        factorial *= i;
                    }
                    out.println("<p>The factorial of " + number + " is: <strong>" + factorial + "</strong></p>");
                }
            } catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Please enter a valid number.</p>");
            }
        }
    %>
</body>
</html>
