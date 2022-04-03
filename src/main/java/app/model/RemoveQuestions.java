package app.model;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@WebServlet(
		name = "RemoveQuestions",
		urlPatterns = {"/RemoveQuestions"}
		)
public class RemoveQuestions extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "admin", "salasana");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		
		String id=request.getParameter("id");
		ArrayList<Question> list=null;
		if (dao.getConnection()) {
			
		list=dao.RemoveQuestion(id);
		System.out.println("connected");
		System.out.println(list);
		
	}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("questions", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/RemoveQuestions.jsp");
		rd.forward(request,  response);
		
	}
}