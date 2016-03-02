package auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Profile extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private String authorizedUser = "peba";
	private String authorizedUserPass = "1111";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String userPass = (String) session.getAttribute("userPass");

		if (userName == null && userPass == null)
		{
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("</head>");
			out.println("<title>Profile Page</title>");
			out.println("<body bgcolor='#cbe4ec'>");
			out.println("<p><font face='Calibri'><h1>Access Denied.</h1></font></p>");
			out.println("<p><font face='Calibri'>To access this page, You must be logged in. <a href='loginpage.html'><b>Click here to login</b></a>.");
			out.println("</body>");
			out.println("</html>");
		}
		else
		{
			System.out.println("!! - GET");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("</head>");
			out.println("<title>Profile Page</title>");
			out.println("<body bgcolor='#cbe4ec'>");
			out.println("<p><font face='Calibri'><h1>Hey " + userName + ", your session is still active!</h1></font></p>");
			out.println("<p><font face='Calibri'>You have accessed this page via the GET method and guess what, ");
			out.println("Your session is still active. How about <a href='Logout'><b>logging out</b></a>?</font></p>");
			out.println("</body>");
			out.println("</html>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");

		if (authorizedUser.equals(userName) && authorizedUserPass.equals(userPass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("userPass", userPass);

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Profile Page</title>");
			out.println("<body bgcolor='#cbe4ec'>");
			out.println("<p><font face='Calibri'><h1>Profile Page</h1></font></p>");
			out.println("<p><font face='Calibri'>Welcome to your profile page <b>" + userName + "</b>, how are you today?<br>");
			out.println("Yeah, you can't do too much here, but hey why don't you try <a href='Logout'><b>logging out</b></a>?</font></p>");
			out.println("</html>");
		}
		else
		{
			String loginFailedPage = "loginfailed.html";
			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", loginFailedPage);
		}

	}

}
