package app.model;

import java.io.IOException;

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
    urlPatterns = {"/deleteCandidates"}
)
public class DeleteCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCandidates() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Information needed to check session status
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		String myName = (String)session.getAttribute("uname");
		
		// Checking is there a current session
	    if (myName != null) {
	    	String id = request.getParameter("id");
	    	ArrayList<Candidates> list = null;
	    	
	    	// Checking that there is given an id so can delete
	    	if (id != null) {
	    		list = Dao.deleteCandidate(id);
		    	response.sendRedirect("/candidates");
		    	
	    	}
	    	
	    	// If no id was given
	    	else {
	    		response.sendRedirect("/candidates");
	    		
	    	}
	    	
	    }
	    
	    // If there is no session
	    else {
	    	response.sendRedirect("http://localhost:8080/");
	    }
		
	}

/*
	private Dao dao;
	public void init() {
		dao=new Dao();
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
	*/
}