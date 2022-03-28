package app.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

@WebServlet(
		name = "AddUserServlet",
		urlPatterns = {"/add"}
		)
public class AddUser extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		response.sendRedirect("index.html");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		
		Dao dao = new Dao();
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		
		String salt = SecurityUtils.getSalt();
		String hashpw = SecurityUtils.getPasswordHashed(password, salt);
		
		dao.addUser(uname,  hashpw, salt);
		
		dao.close();
		response.sendRedirect("index.html");
		
	}
}