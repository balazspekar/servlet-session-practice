package auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");

		session.invalidate();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("</head>");
		out.println("<title>Logged out</title>");
		out.println("<body bgcolor='#cbe4ec'>");
		out.println("<p><font face='Calibri'><h1>See you later, " + userName + "!</h1></font></p>");
		out.println("<p><font face='Calibri'>We have invalidated your session, consider it as a safe logout.<br>");
		out.println("Feel free to <a href='loginpage.html'><b>log in again</b></a> anytime.</font></p>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// it's unlikely that a POST occurs ever
	}

}
