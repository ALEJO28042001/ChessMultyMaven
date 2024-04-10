package org.example.demochess;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.example.entities.ModelPerson;
import org.example.entities.Person;

@WebServlet(name = "Logup", value = "/Logup")

public class Logup extends HttpServlet {private static final long serialVersionUID = 1L;

	public Logup() {
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
        out.println("<title>Get User Information</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Enter the required data information:</h2>");
        out.println("<form action=\"\" method=\"get\">\r\n"
        		+ "    Name: <input type=\"text\" name=\"name\"><br>\r\n"
        		+ "    Age: <input type=\"text\" name=\"age\"><br>\r\n"
        		+ "    Password: <input type=\"password\" name=\"password\"><br> \r\n"
        		+ "    <input type=\"submit\" value=\"Logup\">\r\n"
        		+ "</form>");
        
        out.println("</body>");
        out.println("</html>");

        // Retrieve name and age from the request
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
	    
        
	    if (name != null && !name.isEmpty() && age != null && !age.isEmpty() && password != null && !password.isEmpty()) {
	 	        
	        Person p = new Person();
	        p.setEdad(Integer.parseInt(age));
	        p.setName(name);
	        p.setPassword(password);
	        ModelPerson mp= ModelPerson.getInstance();
			mp.savePerson(p);
			out.println("User Created with id:"+p.getId());
			out.println("<a href='/Login' class='login-link'>Login</a>");
			
			// Output the JavaScript function to open the popup window
			out.println("<script>");
			out.println("function openPopup() {");
			out.println("    var popupWindow = window.open('', 'popupWindow', 'width=400,height=300');");
			out.println("    popupWindow.document.write('<h2>User Created</h2>');");
			out.println("}");
			out.println("</script>");
			
			// Call the JavaScript function to open the popup window
			out.println("<script>openPopup();</script>");
			//out.println("    }, 2000);"); // 2000 milliseconds delay (adjust as needed)
			//response.sendRedirect("/chess.html"); // Redirect to a success page
	    }
	    else {
	    	out.println("<div style='background-color: #ffcccc; color: #ff0000; padding: 10px; border-radius: 5px;'>");
	        out.println("Invalid Info");
	        out.println("</div>");
			//response.sendRedirect(request.getRequestURI());
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
