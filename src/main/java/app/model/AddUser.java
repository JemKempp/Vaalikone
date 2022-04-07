package app.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import dao.Dao;

@WebServlet(
		name = "AddUser",
		urlPatterns = {"/add"}
		)
public class AddUser extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		response.sendRedirect("/jsp/adduser.jsp");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {

		Dao dao = new Dao();
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");

		
		String salt = Security.getSalt();
		String hashpw = Security.getPasswordHashed(password, salt);
	
		
		dao.addUser(uname,  hashpw, salt);
		
		dao.close();
		response.sendRedirect("/jsp/adduser.jsp");
		
	}
}