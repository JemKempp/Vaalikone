package app.model;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;


@WebServlet(
    name = "DeleteCandidates",
    urlPatterns = {"/deleteCandidates"}
)
public class DeleteCandidates extends HttpServlet {


	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "jkt", "riina");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String ehdokas_id=request.getParameter("ehdokas_id");
		ArrayList<Candidates> list=null;
		if (dao.getConnection()) {
			list=dao.deleteCandidate(ehdokas_id);
		}
		request.setAttribute("candidatelist", list);
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}
}