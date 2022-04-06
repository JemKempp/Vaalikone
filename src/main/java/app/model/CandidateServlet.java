package app.model;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import app.model.Candidates;
import app.model.Questions;
import app.model.Vastaukset;
import dao.Dao;

/**
 * Servlet implementation class CandidatesServlet
 */
@WebServlet("/CandidatesServlet")
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dao.Dao dao=null;
	
	public void init() {

		// connection_url_admin = jdbc:mysql://localhost:3306
		// connection_url = jdbc:mysql://localhost:3306/vaalikone
		String url = getServletContext().getInitParameter("connection_url");
		String user = getServletContext().getInitParameter("username");
		String password = getServletContext().getInitParameter("passwd");
		
		dao = new Dao(url, user, password);

		// dao=new DAO.Dao("jdbc:mysql://localhost:3306/vaalikone", "user", "password");
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ArrayList<Candidates> list=null;
		if (dao.getConnection()){
			list=dao.readAllCandidates();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("Candidates", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowCandidates.jsp");
		rd.forward(request, response);
		
	}
		
		
/*
@WebServlet(
        name = "CandidateServlet",
        urlPatterns = {"/Candidates"}
        )
public class CandidateServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // if sessions does not exist, create new one
        HttpSession session = request.getSession();

        Dao dao = new Dao();
        ArrayList<Candidates> candidates = dao.readAllCandidates();

        session.setAttribute("allcandidates", candidates);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/ShowCandidates.jsp");
        rd.forward(request, response);

    }
    */
    /*
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // if sessions does not exist, create new one
        HttpSession session = request.getSession();

        Dao dao = new Dao();
        ArrayList<Questions> questions = dao.readAllQuestions();

        session.setAttribute("allquestions", questions);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/showall.jsp");
        rd.forward(request, response);

    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        // if sessions does not exist, create new one
        HttpSession session = request.getSession();

        Dao dao = new Dao();
        ArrayList<Vastaukset> vastaukset = dao.readAllVastaukset();

        session.setAttribute("allvastaukset", vastaukset);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/showall.jsp");
        rd.forward(request, response);

    }
*/
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        doGet(request, response);
    }

}