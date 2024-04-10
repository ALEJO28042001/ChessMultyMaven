package org.example.demochess;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.example.entities.ModelPerson;
import org.example.entities.Person;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ModelPerson mp = ModelPerson.getInstance();
    
    public Login() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type of the response
        response.setContentType("text/html");
        
        // Get PrintWriter object
        PrintWriter out = response.getWriter();
        
        // HTML form to collect Id and Password
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Enter the required data information to log in:</h2>");
        out.println("<form action=\"\" method=\"get\">");
        out.println("Id: <input type=\"text\" name=\"idd\"><br>");
        out.println("Password: <input type=\"password\" name=\"password\"><br>"); 
        out.println("<input type=\"submit\" value=\"Login\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        // Retrieve id and password from the request
        String id = request.getParameter("idd");
        String password = request.getParameter("password");

        if (id != null && !id.isEmpty() && password != null && !password.isEmpty()) {
            try {
                Person loginPerson = mp.searchPerson(Integer.parseInt(id));
                if (loginPerson != null) {
                    if (password.equals(loginPerson.getPassword())) {
                        // Set cookies for token and name
                        String token = "your_token_here"; // Generate your token
                        String name = loginPerson.getName();
                        setCookie(response, "token", token, 7 * 24 * 60 * 60); // Set token cookie to expire in 7 days
                        setCookie(response, "name", name, 7 * 24 * 60 * 60); // Set name cookie to expire in 7 days

                        response.sendRedirect("/myProfile.html"); // Redirect to a success page
                    } else {
                        out.println("<div style='background-color: #ffcccc; color: #ff0000; padding: 10px; border-radius: 5px;'>");
                        out.println("Incorrect password");
                        out.println("</div>");
                    }
                } else {
                    out.println("<div style='background-color: #ffcccc; color: #ff0000; padding: 10px; border-radius: 5px;'>");
                    out.println("Invalid user");
                    out.println("</div>");
                }
            } catch (NumberFormatException e) {
                out.println("<div style='background-color: #ffcccc; color: #ff0000; padding: 10px; border-radius: 5px;'>");
                out.println("Invalid user ID");
                out.println("</div>");
            }
        } else {
            out.println("<div style='background-color: #ffcccc; color: #ff0000; padding: 10px; border-radius: 5px;'>");
            out.println("Invalid information");
            out.println("</div>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    // Method to set a cookie
    private void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge); // Set the maximum age of the cookie in seconds
        response.addCookie(cookie);
    }
}
