/*
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

import dao.Dao;
import app.model.Candidates;


@WebServlet(
		name = "editcandidate",
		urlPatterns = {"/editcandidate"}
		)
public class editcandidate extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		System.out.println("0");
		// Create connection
		HttpSession session = request.getSession();
		String idValue = request.getParameter("ehdokas_id");
		int id = Integer.parseInt(idValue);
		Dao dao = new Dao();
		Candidates candidates = dao.getCandidatesInfo(id);
		session.setAttribute("candidate", candidates);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/editcandidate.jsp");
		System.out.println("help");
		rd.forward(request, response);
	System.out.println("1");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
				//Create session
				HttpSession session = request.getSession();
						
				Dao dao=new Dao();
				Candidates candidates = readCandidates(request);
				
				dao.editcandidate(candidates);
				
				dao.close();
				
				System.out.println("2");
				
				 // redirect to candidates list
				response.sendRedirect("/showcandidates"); 
				
				System.out.println("3");

	}
	
	

	private Candidates readCandidates(HttpServletRequest request) {
		Candidates candidates=new Candidates();
		candidates.setEhdokas_id(Integer.parseInt(request.getParameter("ehdokas_id")));
		candidates.setEtunimi(request.getParameter("etunimi"));
		candidates.setSukunimi(request.getParameter("sukunimi"));
		candidates.setPuolue(request.getParameter("puolue"));
		candidates.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
		candidates.setIka(Integer.parseInt(request.getParameter("ika")));
		candidates.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		candidates.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		candidates.setAmmatti(request.getParameter("ammatti"));
		
		return candidates;
	}
	
}
*/

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
	    name = "editcandidate",
	    urlPatterns = {"/editcandidate"}
	)
	public class editcandidate extends HttpServlet {
		private Dao dao;
		public void init() {
			dao=new Dao();
		}
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException {
			Candidates c=dao.readCandidate(request.getParameter("id"));
			HttpSession session = request.getSession();
			session.setAttribute("candidates", c);
			response.sendRedirect("/jsp/editcandidate.jsp");
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
		     
			/*
			Candidates c=dao.saveVaalikone(request.getParameter("id"));
			HttpSession session = request.getSession();
			session.setAttribute("candidates", c);
			*/

			String ehdokas_id=request.getParameter("ehdokas_id");
			String etunimi=request.getParameter("etunimi");
			String sukunimi=request.getParameter("sukunimi");
			String puolue=request.getParameter("puolue");
			String kotipaikkakunta=request.getParameter("kotipaikkakunta");
			String ika=request.getParameter("ika");
			String miksi_eduskuntaan=request.getParameter("miksi_eduskuntaan");
			String mita_asioita_haluat_edistaa=request.getParameter("mita_asioita_haluat_edistaa");
			String ammatti=request.getParameter("ammatti");
			
			Candidates e=new Candidates(ehdokas_id, etunimi, sukunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
			
			ArrayList<Candidates> list=null;
			if (dao.getConnection()) {
				list=dao.editcandidate(e);
			}
			
			request.setAttribute("candidateslist", list);
			RequestDispatcher rd=request.getRequestDispatcher("./showcandidates");
			rd.forward(request, response);
		}

	}
	
