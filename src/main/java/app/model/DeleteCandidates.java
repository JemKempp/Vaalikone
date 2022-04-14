package app.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import app.model.Candidates;

@WebServlet(
		name = "DeleteCandidates",
		urlPatterns = {"/deletecandidates"}
		)
public class DeleteCandidates extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();

		String idValue = request.getParameter("ehdokas_id");

		if (idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);

				Dao dao = new Dao();
				Candidates candidate = dao.getCandidatesInfo(id);

				session.setAttribute("candidate", candidate);

				RequestDispatcher rd = request.getRequestDispatcher("jsp/deletecandidates.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("jsp/DeleteCandidates.jsp");
		}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
			
		// Create connection
		
		Dao dao=new Dao();
		//test branch
		
		//Test github


		
		try {
			dao.deleteCandidate(Integer.parseInt(request.getParameter("ehdokas_id")));
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	

		dao.close();

		// Back to list after actions
		response.sendRedirect("/showcandidates");
	}
}



